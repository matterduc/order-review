package com.crosssolutions.user.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Verification token used to activate the user and to set the password
 *
 * @author Duc.Nguyen
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "T_VERIFICATION_TOKEN")
public class VerificationToken implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** Technical Id */
    @Id
    @Column(name = "TKN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Unique token generated for the user */
    @NonNull
    @Column(name = "TKN_VALUE")
    private String token;

    /** Date of expiration */
    @NonNull
    @Column(name = "TKN_EXPIRY_DATE", nullable = false)
    private Date expiryDate;

    /** The user who owns the token */
    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ID", nullable = false)
    private User user;

}