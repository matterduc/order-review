package com.crosssolutions.user.service.event;

import org.springframework.context.ApplicationEvent;

import com.crosssolutions.user.domain.User;
import com.crosssolutions.user.domain.VerificationToken;

import lombok.Getter;

/**
 * Event fired when a new user is added
 *
 * @author Duc.Nguyen
 */
@Getter
public class OnSendActivationMailEvent extends ApplicationEvent {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** Password init template */
    private static final String PASSWORD_INIT_TEMPLATE = "password-init-email.ftl";

    /** Expired init template */
    private static final String EXPIRED_INIT_TEMPLATE = "expired-init-email.ftl";

    /** The verification token */
    private String token;

    /** The recently created user */
    private User user;

    /** Mail template */
    private String template = PASSWORD_INIT_TEMPLATE;

    /**
     * Constructs the event using the params
     *
     * @param user
     *            the created user
     * @param tokenthe
     *            generated token
     */
    public OnSendActivationMailEvent(final User user, final String token) {
        super(user);

        this.token = token;
        this.user = user;
        template = PASSWORD_INIT_TEMPLATE;
    }

    /**
     * Construct the event using the verification entity
     * 
     * @param verificationToken
     *            verification object
     */
    public OnSendActivationMailEvent(final VerificationToken verificationToken) {
        super(verificationToken.getUser());

        token = verificationToken.getToken();
        user = verificationToken.getUser();
        template = EXPIRED_INIT_TEMPLATE;
    }
}
