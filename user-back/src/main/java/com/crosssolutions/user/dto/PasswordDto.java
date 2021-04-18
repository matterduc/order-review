package com.crosssolutions.user.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Holds the password to set
 *
 * @author Duc.Nguyen
 */
@Data
public class PasswordDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** The verification token */
    private String token;

    /** The password to set */
    private String password;
}
