package com.crosssolutions.user.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * A declared application's User. Users who can access an application
 *
 * @author Duc.Nguyen
 */
@Getter
@Setter
@Entity
@Table(name = "T_USER")
public class User extends AbstractAuditingEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** User Id */
    private Long id;

    /** User first name */
    @Column(name = "USR_FIRST_NAME")
    private String firstName;

    /** User last name */
    @Column(name = "USR_LAST_NAME")
    private String lastName;

    /** Is the user active */
    @Column(name = "USR_IS_ACTIVE")
    private boolean active;

    /** User email address */
    @Column(name = "USR_EMAIL")
    private String email;

    /** User's password Hash */
    @Column(name = "USR_PASS_HASH")
    private String passwordHash;

    /** Department or Company where the user belongs */
    @Column(name = "USR_DEPT")
    private String department;

    @ManyToMany
    @JoinTable(name = "T_USER_APPS", joinColumns = @JoinColumn(name = "USR_ID"), inverseJoinColumns = @JoinColumn(name = "APP_ID"))
    /** List of applications that the user has access to */
    private Set<Application> applications;
}
