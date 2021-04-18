package com.crosssolutions.user.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crosssolutions.user.domain.Application;
import com.crosssolutions.user.dto.ApplicationDto;
import com.crosssolutions.user.mapper.IApplicationMapper;
import com.crosssolutions.user.repository.ApplicationRepository;
import com.crosssolutions.user.service.IApplicationService;
import com.crosssolutions.user.service.exception.ElementNotFoundException;

/**
 * Service for applications management
 *
 * @author Duc.Nguyen
 */
@Service
@Transactional
public class ApplicationService extends AbstractService<Application> implements IApplicationService {

    @Autowired
    private IApplicationMapper mapper;

    @Autowired
    private ApplicationRepository repository;

    /**
     * @see com.crosssolutions.user.service.IApplicationService#findApplications()
     */
    @Override
    @Transactional(readOnly = true)
    public List<ApplicationDto> findApplications() {
        return mapper.asApplications(repository.findAll(new Sort(Sort.Direction.ASC, "name")));
    }

    /**
     * @see com.crosssolutions.user.service.IApplicationService#findById(java.lang.Long)
     */
    @Override
    @Transactional(readOnly = true)
    public ApplicationDto findById(final Long id) {

        final Optional<Application> app = repository.findById(id);

        if (app.isPresent()) {
            return mapper.asApplicationDto(app.get());
        } else {
            throw new ElementNotFoundException(Application.class, id);
        }
    }

    /**
     * @see com.crosssolutions.user.service.IApplicationService#save(com.crosssolutions.user.dto.ApplicationDto)
     */
    @Override
    public Long save(final ApplicationDto application) {

        final Application entity = mapper.asApplication(application);

        entity.setCreatedBy("Z.DRISSI");
        entity.setAppId(UUID.randomUUID().toString());

        final Application app = repository.save(entity);

        return app.getId();
    }

    /**
     * @see com.crosssolutions.user.service.IApplicationService#update(com.crosssolutions.user.dto.ApplicationDto)
     */
    @Override
    public void update(final ApplicationDto application) {

        final Optional<Application> app = repository.findById(application.getId());

        if (app.isPresent()) {
            mapper.updateApplicationFromApplicationDto(application, app.get());
        } else {
            throw new ElementNotFoundException(Application.class, application.getId());
        }

    }

    /**
     * @see com.crosssolutions.user.service.IApplicationService#delete(java.lang.Long)
     */
    @Override
    public void delete(final Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ElementNotFoundException(Application.class, id);
        }
    }
}
