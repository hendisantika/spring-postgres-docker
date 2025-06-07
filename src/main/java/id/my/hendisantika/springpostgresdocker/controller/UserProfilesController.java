package id.my.hendisantika.springpostgresdocker.controller;

import id.my.hendisantika.springpostgresdocker.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-postgres-docker
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 07/06/25
 * Time: 08.40
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-profiles")
public class UserProfilesController {

    private final UserProfileService userProfileService;

}
