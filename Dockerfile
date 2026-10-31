# syntax=docker/dockerfile:1.4
FROM --platform=$BUILDPLATFORM maven:3.9.12-eclipse-temurin-25 AS builder
LABEL authors="hendisantika"
WORKDIR /workdir/server
COPY pom.xml /workdir/server/pom.xml
RUN mvn -B dependency:go-offline

COPY src /workdir/server/src
RUN mvn -B clean package -DskipTests

FROM builder AS dev-envs
RUN <<EOF2
apt-get update
apt-get install -y --no-install-recommends git
EOF2

RUN <<EOF2
useradd -s /bin/bash -m vscode
groupadd docker
usermod -aG docker vscode
EOF2
# install Docker tools (cli, buildx, compose)
COPY --from=gloursdocker/docker / /
CMD ["mvn", "spring-boot:run"]

FROM builder AS prepare-production
RUN mkdir -p target/dependency
WORKDIR /workdir/server/target/dependency
RUN jar -xf ../*.jar

FROM eclipse-temurin:25-jre-alpine

EXPOSE 8080
VOLUME /tmp
ARG DEPENDENCY=/workdir/server/target/dependency
COPY --from=prepare-production ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=prepare-production ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=prepare-production ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","id.my.hendisantika.springpostgresdocker.SpringPostgresDockerApplication"]
