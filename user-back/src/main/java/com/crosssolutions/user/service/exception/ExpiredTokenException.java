/**
 *
 */
package com.crosssolutions.user.service.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

/**
 * Exception thrown when the token is expired
 *
 * @author Duc.Nguyen
 */
public class ExpiredTokenException extends AbstractThrowableProblem {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception with a token
     *
     * @param token
     *            the expired token
     * @param email
     *            email of the user
     */
    public ExpiredTokenException(final String token, final String email) {
        super(ErrorConstants.DEFAULT_TYPE, String.format("The token '%s' has expired", token), Status.BAD_REQUEST, email);
    }
}
