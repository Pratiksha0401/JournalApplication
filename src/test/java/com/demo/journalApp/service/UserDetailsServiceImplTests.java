package com.demo.journalApp.service;

import com.demo.journalApp.entity.User;
import com.demo.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
public class UserDetailsServiceImplTests {

    /**
     * The service under test. Injected with mocked dependencies.
     */
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Mocked user repository used to simulate database interaction.
     */
    @Mock
    private UserRepository userRepository;

    /**
     * Initializes mocks before each test runs.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests the {@code loadUserByUsername(String username)} method of {@link UserDetailsServiceImpl}.
     *
     * <p>This test is currently disabled using {@link Disabled} annotation. When enabled,
     * it verifies that a valid {@link UserDetails} object is returned when the repository
     * returns a valid user entity.</p>
     *
     * <p><strong>Mock behavior:</strong> Any username passed to the repository will return
     * a user object with a static username and password.</p>
     *
     * <p><strong>Assertions:</strong> Checks that the returned UserDetails object is not null.</p>
     */
    @Disabled
    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder()
                        .userName("ram")
                        .password("inrinrick")
                        .roles(new ArrayList<>())
                        .build());

        UserDetails user = userDetailsService.loadUserByUsername("ram");

        Assertions.assertNotNull(user);
    }
}
