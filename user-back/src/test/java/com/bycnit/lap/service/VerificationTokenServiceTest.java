package com.bycnit.lap.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bycnit.lap.domain.User;
import com.bycnit.lap.dto.VerificationTokenDto;
import com.bycnit.lap.repository.UserRepository;
import com.bycnit.lap.service.exception.ExpiredTokenException;
import com.bycnit.lap.service.exception.NonExistentTokenException;

import lombok.SneakyThrows;

/**
 * Unit test for "com.bycnit.lap.service.IVerificationTokenService"
 *
 * @author Z.DRISSI
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class VerificationTokenServiceTest {

    @Autowired
    private IVerificationTokenService service;

    @Autowired
    private UserRepository userRepository;

    @Test
    @SneakyThrows(Exception.class)
    public void whenFindByToken_thenReturnVerificationToken() {

        // Arrange
        final String token = "c0c949a9-ceff-4e42-b80f-2479d911657f-127736";

        // Act
        final VerificationTokenDto verificationToken = service.findByToken(token);

        // Assert
        assertEquals("c0c949a9-ceff-4e42-b80f-2479d911657f-127736", verificationToken.getToken());
        assertEquals("john.doe@bycn.com", verificationToken.getEmail());
    }

    @Test(expected = NonExistentTokenException.class)
    @SneakyThrows(Exception.class)
    public void whenFindByNonExistentToken_thenThrowException() {

        // Arrange
        final String token = "c0c949a9-ceff-4e42-b80f-2479d911657f-1277232";

        // Act
        service.findByToken(token);
    }

    @Test(expected = ExpiredTokenException.class)
    @SneakyThrows(Exception.class)
    public void whenFindByExpiredToken_thenThrowException() {

        // Arrange
        final String token = "c0c949a9-ceff-4e42-b80f-2479d911657f-127789";

        // Act
        service.findByToken(token);
    }

    @Test
    @SneakyThrows(Exception.class)
    public void whenSavingToken_thenReturnVerificationToken() {

        // Arrange
        final User user = userRepository.findById(3L).get();

        // Act
        final String token = service.generateToken(user);

        // Assert
        final VerificationTokenDto verificationToken = service.findByToken(token);
        assertEquals(token, verificationToken.getToken());
        assertTrue(verificationToken.getExpiryDate().after(new Date()));
        assertEquals("baby.john.doe@bycn.com", verificationToken.getEmail());
    }
}
