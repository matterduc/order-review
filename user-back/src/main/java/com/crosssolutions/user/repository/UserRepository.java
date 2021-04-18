package com.crosssolutions.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.crosssolutions.user.domain.User;

/**
 * DAO for user management
 *
 * @author Duc.Nguyen
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
