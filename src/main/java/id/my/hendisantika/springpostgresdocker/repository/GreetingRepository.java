package id.my.hendisantika.springpostgresdocker.repository;

import id.my.hendisantika.springpostgresdocker.entity.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Integer> {
}
