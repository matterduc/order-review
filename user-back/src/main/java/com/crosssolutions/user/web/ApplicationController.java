package com.crosssolutions.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crosssolutions.user.constants.WebConstants;
import com.crosssolutions.user.dto.ApplicationDto;
import com.crosssolutions.user.service.IApplicationService;

/**
 * Controller for applications management
 *
 * @author Duc.Nguyen
 */
@RestController
@RequestMapping(WebConstants.View.APPLICATIONS)
public class ApplicationController {

    @Autowired
    private IApplicationService service;

    /**
     * Returns the list of applications
     *
     * @return a list of applications
     */
    @GetMapping
    public List<ApplicationDto> list() {
        return service.findApplications();
    }

    @GetMapping("/{id}")
    public ApplicationDto get(@PathVariable("id") final Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Long store(@RequestBody final ApplicationDto app) {

        if (app.getId() != null) {
            service.update(app);
            return app.getId();
        }

        return service.save(app);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        service.delete(id);
    }
}
