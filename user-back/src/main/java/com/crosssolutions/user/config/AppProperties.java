package com.crosssolutions.user.config;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Application specific properties
 *
 * @author Duc.Nguyen
 */
@Setter
@Getter
@Component
@ConfigurationProperties("app")
public class AppProperties {

    /** Expiration duration for verification tokens */
    private int expirationHours;

    /** Default mail sender */
    private String defaultSender;

    /** Activation URL */
    private String activationUrl;

    /** Argos Login */
    private String argosLogin;

    /** Argos Password */
    private String argosPassword;

    /** Argos URL */
    private String argosUrl;

    /**
     * Generates the expiration date based on the expiration hours
     *
     * @return the expiration date
     */
    public Date getExpirationDate() {
        return DateUtils.addHours(new Date(), expirationHours);
    }
}
