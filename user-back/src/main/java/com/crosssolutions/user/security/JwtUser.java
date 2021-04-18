package com.crosssolutions.user.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Authenticated User
 *
 * @author Duc.Nguyen
 */
@Getter
@Setter
public class JwtUser implements UserDetails {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String idArgos;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private Date lastPasswordResetDate;

    private boolean enabled;

    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
