package com.crosssolutions.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Administrator of Master Key
 *
 * @author Duc.Nguyen
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "T_MK_USER")
public class MasterKeyUser extends AbstractAuditingEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** Master Key User ID */
    @Id
    @Column(name = "MKU_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MKU_ARGOS_ID")
    private String idArgos;

    /** Master Key Login */
    @Column(name = "MKU_USERNAME")
    private String username;

    /** First Name */
    @Column(name = "MKU_FIRST_NAME")
    private String firstName;

    /** Last Name */
    @Column(name = "MKU_LAST_NAME")
    private String lastName;

    /** Email address */
    @Column(name = "MKU_EMAIL")
    private String email;

    /** Password Hash */
    @Column(name = "MKU_PASSWORD_HASH")
    private String password;

    /** Is the Master Key User Active */
    @Column(name = "MKU_IS_ENABLED")
    private boolean enabled;

    /** Last Password Reset Date */
    @Column(name = "MKU_PWD_RESET_DATE")
    private Date lastPasswordResetDate;
}
