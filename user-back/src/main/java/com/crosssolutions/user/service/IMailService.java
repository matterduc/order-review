package com.crosssolutions.user.service;

import java.util.Map;

/**
 * Mail mangement service contract
 *
 * @author Duc.Nguyen
 */
public interface IMailService {

    /**
     * Sends the email
     *
     * @param email
     *            the recipient of the email
     * @param subject
     *            the subject of the email
     * @param body
     *            email's content
     */
    void sendEmail(String email, String subject, String body);

    /**
     * Builds the email using the parameters
     *
     * @param template
     *            the template
     * @param input
     *            model parameters
     * @return email body
     */
    String buildMail(String template, Map<String, Object> input);
}
