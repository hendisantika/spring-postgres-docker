package id.my.hendisantika.springpostgresdocker.controller;

import id.my.hendisantika.springpostgresdocker.entity.Greeting;
import id.my.hendisantika.springpostgresdocker.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/")
    public String showHome(String name, Model model) {
        Greeting dockerGreeting = greetingRepository.findById(1).orElse(new Greeting("Not Found 😕"));
        model = model.addAttribute("name", dockerGreeting.getName());
        return "home";
    }
}
