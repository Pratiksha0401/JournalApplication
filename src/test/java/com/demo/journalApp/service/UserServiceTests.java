package com.demo.journalApp.service;

import com.demo.journalApp.entity.User;
import com.demo.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test class for {@link UserService}.
 *
 * <p>This class tests the business logic implemented in the {@link UserService} using actual Spring context.</p>
 *
 * <p>Note: The test methods are currently disabled using {@link Disabled}, so they will be skipped during test execution.
 * You can remove the annotation to enable them as needed.</p>
 */
@SpringBootTest
public class UserServiceTests {

    /**
     * Autowired repository to verify persistence operations if needed.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Service under test.
     */
    @Autowired
    private UserService userService;

    /**
     * Parameterized test for saving a new user using dynamic test data.
     *
     * <p>Uses a custom {@link ArgumentsSource} to provide various {@link User} instances.</p>
     *
     * <p><strong>Validation:</strong> Asserts that the user was saved successfully by checking that
     * {@code userService.saveNewUser(user)} returns true.</p>
     *
     * <p><strong>Note:</strong> This test is disabled with {@code @Disabled}. Remove it to run the test.</p>
     *
     * @param user the user entity to be saved
     */
    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    /**
     * Sample parameterized test to verify basic integer addition logic.
     *
     * <p>Each set of parameters is provided via {@link CsvSource}.</p>
     *
     * <p><strong>Parameters:</strong>
     * <ul>
     *     <li>a - First integer</li>
     *     <li>b - Second integer</li>
     *     <li>expected - Expected sum</li>
     * </ul></p>
     *
     * <p><strong>Purpose:</strong> This test is likely for demonstration or testing the parameterized test setup itself.</p>
     *
     * <p><strong>Note:</strong> This test is disabled with {@code @Disabled}. Remove it to execute.</p>
     *
     * @param a first number
     * @param b second number
     * @param expected expected result of a + b
     */
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a + b);
    }
}