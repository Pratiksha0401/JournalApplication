package com.demo.journalApp.service;

import com.demo.journalApp.entity.User;
import com.demo.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

/**
 * Test class for {@link UserDetailsServiceImpl}.
 * This class uses Spring Boot's testing support with Mockito to verify the behavior
 * of the `loadUserByUsername` method in the service layer.
 *
 * It mocks the {@link UserRepository} dependency to test only the service logic
 * and ensures that a valid UserDetails object is returned when a known username is queried.
 *
 * Uses the "test" profile (if configured via @ActiveProfiles) for isolated environment.
 */
@SpringBootTest
public class UserDetailsServiceImplTests1 {

    /**
     * The service under test. This will have real Spring context injected.
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Mocked repository to stub data for the user lookup.
     */
    @MockBean
    private UserRepository userRepository;

    /**
     * Tests the {@code loadUserByUsername(String username)} method of {@link UserDetailsServiceImpl}.
     *
     * <p>This test mocks the {@link UserRepository} to return a predefined {@link User} entity
     * when any username is passed. It then verifies that the service correctly loads
     * the corresponding {@link UserDetails} object and that it is not null.</p>
     *
     * <p>Key validations:
     * <ul>
     *     <li>Ensures the returned UserDetails object is not null.</li>
     *     <li>Mocks are correctly used to isolate service logic from data access layer.</li>
     * </ul></p>
     */
    @Test
    void loadUserByUsernameTest1() {
        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder()
                        .userName("ram")
                        .password("inrinrick")
                        .roles(new ArrayList<>())
                        .build());

        UserDetails user = userDetailsService.loadUserByUsername("ram");

        // Assert that the user details object is correctly returned
        Assertions.assertNotNull(user);
    }
}
