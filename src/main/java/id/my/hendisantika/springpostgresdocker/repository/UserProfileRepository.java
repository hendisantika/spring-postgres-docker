package id.my.hendisantika.springpostgresdocker.repository;

import id.my.hendisantika.springpostgresdocker.entity.UserProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-postgres-docker
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 07/06/25
 * Time: 08.35
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfiles, UUID> {
}
