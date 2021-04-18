package com.crosssolutions.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crosssolutions.user.domain.MasterKeyUser;

/**
 * DAO for the application Administrators mangement
 *
 * @author Duc.Nguyen
 */
public interface MasterKeyUserRepository extends JpaRepository<MasterKeyUser, Long> {

    /**
     * Finds the user by his username
     * 
     * @param username
     *            username
     * @return entity
     */
    MasterKeyUser findByUsername(String username);

}
