package com.crosssolutions.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crosssolutions.user.domain.MasterKeyUser;
import com.crosssolutions.user.mapper.IMasterKeyUserMapper;
import com.crosssolutions.user.repository.MasterKeyUserRepository;
import com.crosssolutions.user.security.JwtUser;

/**
 * @author Duc.Nguyen
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private MasterKeyUserRepository repository;

    @Autowired
    private IMasterKeyUserMapper mapper;

    /**
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final MasterKeyUser admin = repository.findByUsername(username);

        if (admin != null) {
            final JwtUser user = mapper.asJwtUser(admin);

            return user;
        }
        throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    }
}
