package id.my.hendisantika.springpostgresdocker;

import id.my.hendisantika.springpostgresdocker.entity.UserProfiles;
import id.my.hendisantika.springpostgresdocker.repository.GreetingRepository;
import id.my.hendisantika.springpostgresdocker.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest
class SpringPostgresDockerApplicationTests {
    @Container
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:17.5-alpine3.22")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @BeforeEach
    void deleteAll() {
        greetingRepository.deleteAll();
        userProfileRepository.deleteAll();
    }

    @Test
    void testUserProfilesTableCreation() {
        // Create a new user profile
        UserProfiles userProfile = new UserProfiles();
        userProfile.setFirstName("Test");
        userProfile.setLastName("User");
        userProfile.setEmail("test@example.com");
        userProfile.setBirthDate(new Date());
        userProfile.setSex(1);
        userProfile.setCreateBy(UUID.randomUUID());

        // Save the user profile
        UserProfiles savedUserProfile = userProfileRepository.save(userProfile);

        // Verify the user profile was saved with an ID
        assertNotNull(savedUserProfile.getId());

        // Clean up
        userProfileRepository.delete(savedUserProfile);
    }
}
