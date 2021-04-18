/**
 *
 */
package com.crosssolutions.user.service.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

/**
 * Exception thrown when the token does not exist
 *
 * @author Duc.Nguyen
 */
public class NonExistentTokenException extends AbstractThrowableProblem {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception with a token
     *
     * @param token
     *            the non existent token
     */
    public NonExistentTokenException(final String token) {
        super(ErrorConstants.DEFAULT_TYPE, String.format("The token '%s' does not exist", token), Status.FORBIDDEN);
    }
}
