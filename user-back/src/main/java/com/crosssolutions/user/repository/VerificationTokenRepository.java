package com.bycnit.lap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bycnit.lap.domain.VerificationToken;

/**
 * Dao for Token management
 *
 * @author Z.DRISSI
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    /**
     * Retrieves the verification token by the token value
     *
     * @param token
     *            the token value
     * @return an optional object
     */
    @Query("from VerificationToken v JOIN FETCH v.user where v.token = ?1")
    Optional<VerificationToken> findByToken(String token);
}
