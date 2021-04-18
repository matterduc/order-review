package com.crosssolutions.user.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Service for applications management
 *
 * @author Duc.Nguyen
 */
@Data
public class ApplicationDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** Application Id */
    private Long id;

    /** Application Name */
    private String name;

    /** Application Description */
    private String description;

    /** Application Unique Id */
    private String appId;
}
