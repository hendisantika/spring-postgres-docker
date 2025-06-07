package id.my.hendisantika.springpostgresdocker.controller;

import id.my.hendisantika.springpostgresdocker.entity.UserProfiles;
import id.my.hendisantika.springpostgresdocker.exception.ResourceNotFoundException;
import id.my.hendisantika.springpostgresdocker.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    public UserProfiles createUserProfile(@RequestBody UserProfiles userProfile) {
        userProfile.setCreateBy(UUID.randomUUID());
        return userProfileService.createUserProfile(userProfile);
    }

    @GetMapping
    public List<UserProfiles> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfiles> getUserProfileById(@PathVariable UUID id) {
        UserProfiles userProfile = userProfileService.getUserProfileById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User profile not found"));
        return ResponseEntity.ok(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfiles> updateUserProfile(@PathVariable UUID id, @RequestBody UserProfiles userProfile) {
        userProfile.setUpdateBy(UUID.randomUUID());
        UserProfiles updatedUserProfile = userProfileService.updateUserProfile(id, userProfile);
        return ResponseEntity.ok(updatedUserProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable UUID id) {
        userProfileService.deleteUserprofile(id);
        return ResponseEntity.noContent().build();
    }
}
