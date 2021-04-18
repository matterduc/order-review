package com.crosssolutions.user.security;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
 * An authentication response
 *
 * @author Duc.Nguyen
 */
@Data
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    /** Authentication token */
    private final String token;

    /** Holds infos about the connected user */
    private final UserDetails currentUser;
}
