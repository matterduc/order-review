package com.crosssolutions.user.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * The User data transfer object
 *
 * @author Duc.Nguyen
 */
@Data
public class UserDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** User Id */
    private Long id;

    /** User first name */
    @NotBlank
    private String firstName;

    /** User last name */

    @NotBlank
    private String lastName;

    /** Is the user active */
    private boolean active;

    @Email
    /** User email address */
    private String email;

    @NotBlank
    /** Department or Company where the user belongs */
    private String department;

    /** List of applications that the user has access to */
    private Set<ApplicationDto> applications = new HashSet<>();

    /** List of App Ids */
    private List<Long> appIds;
}
