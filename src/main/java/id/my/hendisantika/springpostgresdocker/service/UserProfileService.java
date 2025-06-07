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

    /* Using JDBC */
    /*@Transactional
    public List<Object[]> getUserProfileById(UUID id){
        String sql = "SELECT * FROM user_profiles WHERE id = ?";
        List<Object[]> results = entityManager.createNativeQuery(sql)
                .setParameter(1, id)
                .getResultList();
        //The developer can use row mapper class to
        //map List<Object[]> and List<UserProfilesEntity>
        return results;
    }

    @Transactional
    public int createUserProfile(UserProfilesEntity userProfilesEntity){
        String sql = "INSERT INTO public.user_profiles(" +
                "id, first_name, last_name, email, birth_date, sex, create_by, create_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        entityManager.createNativeQuery(sql)
                .setParameter(1, userProfilesEntity.getId())
                .setParameter(2, userProfilesEntity.getFirstName())
                .setParameter(3, userProfilesEntity.getLastName())
                .setParameter(4, userProfilesEntity.getEmail())
                .setParameter(5, userProfilesEntity.getBirthDate())
                .setParameter(6, userProfilesEntity.getSex())
                .setParameter(7, userProfilesEntity.getCreateBy())
                .setParameter(8, userProfilesEntity.getCreateDate())
                .executeUpdate();
        return 1; //success
    }

    @Transactional
    public int updateUserProfile(UserProfilesEntity userProfilesEntity){
        String sql = "UPDATE user_profiles " +
                "SET first_name=?, last_name=?, email=?, update_by=?, update_date=? " +
                "WHERE id=?";
        entityManager.createNativeQuery(sql)
                .setParameter(1, userProfilesEntity.getFirstName())
                .setParameter(2, userProfilesEntity.getLastName())
                .setParameter(3, userProfilesEntity.getEmail())
                .setParameter(4, userProfilesEntity.getUpdateBy())
                .setParameter(5, userProfilesEntity.getUpdateDate())
                .setParameter(6, userProfilesEntity.getId())
                .executeUpdate();
        return 1; //success
    }

    @Transactional
    public int deleteUserProfileNa(UserProfilesEntity userProfilesEntity){
        String sql = "DELETE FROM public.user_profiles WHERE id=?";

        entityManager.createNativeQuery(sql)
                .setParameter(1, userProfilesEntity.getId())
                .executeUpdate();
        return 1; //success
    }*/
}
