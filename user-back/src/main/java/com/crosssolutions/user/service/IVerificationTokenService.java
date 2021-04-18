package com.crosssolutions.user.service;

import com.crosssolutions.user.domain.User;
import com.crosssolutions.user.dto.PasswordDto;
import com.crosssolutions.user.dto.VerificationTokenDto;

/**
 * Contract for a Verification Token service
 *
 * @author Duc.Nguyen
 */
public interface IVerificationTokenService {

    /**
     * Finds the verification token
     *
     * @param token
     *            token value
     * @return the verification token object
     */
    VerificationTokenDto findByToken(String token);

    /**
     * Generates and saves a token for a user
     *
     * @param user
     *            the user
     * @return the generated token
     */
    String generateToken(User user);

    /**
     * Resends the activation link
     *
     * @param token
     *            verification token
     */
    void resendActivationLink(String token);

    /**
     * Sets the password for the user
     * 
     * @param passwordDto
     *            password dto
     */
    void setPassword(PasswordDto passwordDto);
}
