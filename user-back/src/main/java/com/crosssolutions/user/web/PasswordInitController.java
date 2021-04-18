package com.crosssolutions.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crosssolutions.user.dto.PasswordDto;
import com.crosssolutions.user.dto.VerificationTokenDto;
import com.crosssolutions.user.service.IVerificationTokenService;

/**
 * Controller for applications management
 *
 * @author Duc.Nguyen
 */
@RestController
public class PasswordInitController {

    @Autowired
    private IVerificationTokenService tokenService;

    @GetMapping("/auth/verify-token/{token}")
    public VerificationTokenDto findVerficationToken(@PathVariable final String token) {
        return tokenService.findByToken(token);
    }

    @PostMapping("/auth/resend-activation-link")
    public void resendActivationLink(@RequestBody final String token) {
        tokenService.resendActivationLink(token);
    }

    @PostMapping("/auth/set-password")
    public void setPassword(@RequestBody final PasswordDto passwordDto) {
        tokenService.setPassword(passwordDto);
    }
}
