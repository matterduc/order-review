/**
 *
 */
package com.crosssolutions.user.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crosssolutions.user.config.AppProperties;
import com.crosssolutions.user.domain.User;
import com.crosssolutions.user.domain.VerificationToken;
import com.crosssolutions.user.dto.PasswordDto;
import com.crosssolutions.user.dto.VerificationTokenDto;
import com.crosssolutions.user.mapper.IVerificationMapper;
import com.crosssolutions.user.repository.VerificationTokenRepository;
import com.crosssolutions.user.service.IVerificationTokenService;
import com.crosssolutions.user.service.event.OnSendActivationMailEvent;
import com.crosssolutions.user.service.exception.ExpiredTokenException;
import com.crosssolutions.user.service.exception.NonExistentTokenException;

/**
 * Token verification service
 *
 * @author Duc.Nguyen
 */
@Service
@Transactional
public class VerificationTokenService implements IVerificationTokenService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppProperties properties;

    @Autowired
    private VerificationTokenRepository repository;

    @Autowired
    private IVerificationMapper mapper;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * @see com.crosssolutions.user.service.IVerificationTokenService#findByToken(java.lang.String)
     */
    @Override
    @Transactional(readOnly = true)
    public VerificationTokenDto findByToken(final String token) {

        final Optional<VerificationToken> verificationToken = repository.findByToken(token);

        if (verificationToken.isPresent()) {

            final VerificationToken entity = verificationToken.get();
            final Date expiryDate = entity.getExpiryDate();

            if (expiryDate.after(new Date())) {
                return mapper.asVerificationTokenDto(entity);
            } else {
                throw new ExpiredTokenException(token, entity.getUser().getEmail());
            }
        } else {
            throw new NonExistentTokenException(token);
        }
    }

    /**
     * @see com.crosssolutions.user.service.IVerificationTokenService#generateToken(com.crosssolutions.user.domain.User)
     */
    @Override
    public String generateToken(final User user) {

        final String token = UUID.randomUUID().toString();
        final VerificationToken entity = new VerificationToken(token, properties.getExpirationDate(), user);

        repository.save(entity);

        return token;
    }

    /**
     * @see com.crosssolutions.user.service.IVerificationTokenService#resendActivationLink(java.lang.String)
     */
    @Override
    public void resendActivationLink(final String token) {

        final Optional<VerificationToken> verificationToken = repository.findByToken(token);

        if (verificationToken.isPresent()) {

            final VerificationToken entity = verificationToken.get();

            // Update Token and ExpiryDate
            entity.setToken(UUID.randomUUID().toString());
            entity.setExpiryDate(properties.getExpirationDate());

            // Resend Activation Link
            eventPublisher.publishEvent(new OnSendActivationMailEvent(entity));
        } else {
            throw new NonExistentTokenException(token);
        }
    }

    /**
     * @see com.crosssolutions.user.service.IVerificationTokenService#setPassword(com.crosssolutions.user.dto.PasswordDto)
     */
    @Override
    public void setPassword(final PasswordDto passwordDto) {

        final Optional<VerificationToken> verificationToken = repository.findByToken(passwordDto.getToken());

        if (verificationToken.isPresent()) {
            final VerificationToken entity = verificationToken.get();
            final String passwordHash = passwordEncoder.encode(passwordDto.getPassword());

            entity.getUser().setPasswordHash(passwordHash);

            // Delete the verification token as it's not needed anymore
            repository.delete(entity);
        } else {
            throw new NonExistentTokenException(passwordDto.getToken());
        }
    }
}
