package com.crosssolutions.user.service.event;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.crosssolutions.user.config.AppProperties;
import com.crosssolutions.user.domain.User;
import com.crosssolutions.user.service.IMailService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Duc.Nguyen
 */
@Slf4j
@Component
public class ActivationEmailListener implements ApplicationListener<OnSendActivationMailEvent> {

    @Autowired
    private IMailService mailService;

    @Autowired
    private AppProperties properties;

    /**
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(final OnSendActivationMailEvent event) {

        final User user = event.getUser();
        final String token = event.getToken();

        final Map<String, Object> input = new HashMap<>();

        input.put("user", user);
        input.put("activationLink", buildActivationLink(token));

        final String body = mailService.buildMail(event.getTemplate(), input);
        final String subject = "[MasterKey] Activation de votre compte";

        mailService.sendEmail(user.getEmail(), subject, body);

        log.info("Sendig activation mail to : {}, {}", user.getLastName(), user.getFirstName());
    }

    /**
     * Builds the activation Url using the token
     *
     * @param token
     *            the verification token
     * @return the URL
     */
    private String buildActivationLink(final String token) {
        return properties.getActivationUrl() + token;
    }
}
