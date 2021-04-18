package com.crosssolutions.user.service;

import java.util.List;

import com.crosssolutions.user.dto.ApplicationDto;

public interface IApplicationService {

    /**
     * Gets the list of applications
     * 
     * @return stored applications
     */
    List<ApplicationDto> findApplications();

    /**
     * Returns the application with the id in param
     *
     * @param id
     *            application's id
     * @return application dto
     */
    ApplicationDto findById(Long id);

    /**
     * Saves the application
     *
     * @param application
     *            the application to save
     * @return the Id of the saved application
     */
    Long save(ApplicationDto application);

    /**
     * Updates the application in params
     *
     * @param application
     *            the application to update
     */
    void update(ApplicationDto application);

    /**
     * Deletes the application with the id in param
     *
     * @param id
     *            application's id
     */
    void delete(Long id);
}
