package id.my.hendisantika.springpostgresdocker.service;

import id.my.hendisantika.springpostgresdocker.entity.UserProfiles;
import id.my.hendisantika.springpostgresdocker.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfiles createUserProfile(UserProfiles userProfilesEntity) {
        return userProfileRepository.save(userProfilesEntity);
    }

    public List<UserProfiles> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

}
