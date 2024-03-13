package id.my.hendisantika.springpostgresdocker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-postgres-docker
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/13/24
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "GREETINGS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {

    @Id
    private int id;
    private String name;

}
