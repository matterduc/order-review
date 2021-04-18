package com.crosssolutions.user.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Verification Token DTO
 *
 * @author Duc.Nguyen
 */
@Data
public class VerificationTokenDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** The verification token */
    private String token;

    /** The user's email */
    private String email;

    /** Expiry Date */
    private Date expiryDate;
}
