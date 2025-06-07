package id.my.hendisantika.springpostgresdocker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-postgres-docker
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 07/06/25
 * Time: 08.32
 * To change this template use File | Settings | File Templates.
 */
@Setter
@Getter
@Entity
@Table(name = "user_profiles")
public class UserProfiles {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "sex")
    private int sex;

    @Column(name = "create_by")
    private UUID createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "update_by")
    private UUID updateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Timestamp updateDate;

    @PrePersist
    protected void onCreate() {
        createDate = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = Timestamp.valueOf(LocalDateTime.now());
    }
}
