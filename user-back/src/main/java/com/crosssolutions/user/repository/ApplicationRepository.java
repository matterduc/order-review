package com.crosssolutions.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crosssolutions.user.domain.Application;

/**
 * DAO for applications management
 *
 * @author Duc.Nguyen
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
