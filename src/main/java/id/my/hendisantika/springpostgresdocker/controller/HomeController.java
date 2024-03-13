package id.my.hendisantika.springpostgresdocker.controller;

import id.my.hendisantika.springpostgresdocker.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-postgres-docker
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/13/24
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final GreetingRepository greetingRepository;
}
