package id.my.hendisantika.springpostgresdocker.service;

import id.my.hendisantika.springpostgresdocker.entity.UserProfiles;
import id.my.hendisantika.springpostgresdocker.exception.ResourceNotFoundException;
import id.my.hendisantika.springpostgresdocker.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Transactional
    public UserProfiles createUserProfile(UserProfiles userProfilesEntity) {
        log.info("Creating new user profile: {}", userProfilesEntity);
        return userProfileRepository.save(userProfilesEntity);
    }

    public List<UserProfiles> getAllUserProfiles() {
        log.info("Fetching all user profiles");
        return userProfileRepository.findAll();
    }

    public Optional<UserProfiles> getUserProfileById(UUID id) {
        log.info("Fetching user profile by ID: {}", id);
        return userProfileRepository.findById(id);
    }

    @Transactional
    public UserProfiles updateUserProfile(UUID id, UserProfiles userProfiles) {
        UserProfiles userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User profile not found"));

        userProfile.setFirstName(userProfiles.getFirstName());
        userProfile.setLastName(userProfiles.getLastName());
        userProfile.setEmail(userProfiles.getEmail());

        log.info("Updating user profile: {}", userProfile);
        return userProfileRepository.save(userProfile);
    }

    @Transactional
    public void deleteUserprofile(UUID id) {
        UserProfiles userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User profile not found"));

        log.info("Deleting user profile: {}", userProfile);
        userProfileRepository.delete(userProfile);
    }
}
