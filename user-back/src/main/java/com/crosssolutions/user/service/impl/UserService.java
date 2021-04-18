package com.crosssolutions.user.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crosssolutions.user.domain.Application;
import com.crosssolutions.user.domain.User;
import com.crosssolutions.user.dto.SearchCriteria;
import com.crosssolutions.user.dto.UserDto;
import com.crosssolutions.user.mapper.IUserMapper;
import com.crosssolutions.user.repository.ApplicationRepository;
import com.crosssolutions.user.repository.UserRepository;
import com.crosssolutions.user.repository.specifications.UserSpecification;
import com.crosssolutions.user.service.IUserService;
import com.crosssolutions.user.service.IVerificationTokenService;
import com.crosssolutions.user.service.event.OnSendActivationMailEvent;
import com.crosssolutions.user.service.exception.ElementNotFoundException;

/**
 * Service for user mangement
 *
 * @author Duc.Nguyen
 */
@Service
@Transactional
public class UserService extends AbstractService<User> implements IUserService {

    /** User mapper */
    @Autowired
    private IUserMapper mapper;

    /** User repository */
    @Autowired
    private UserRepository repository;

    @Autowired
    private ApplicationRepository appRepository;

    @Autowired
    private IVerificationTokenService tokenService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * @see com.crosssolutions.user.service.IUserService#findPaginatedUsersByCriteria(java.util.List, org.springframework.data.domain.Pageable)
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserDto> findPaginatedUsersByCriteria(final List<SearchCriteria> criterias, final Pageable pageRequest) {

        final Page<User> page = repository.findAll(new UserSpecification(toSpecifications(criterias)), pageRequest);

        return page.map(mapper::asUserDto);
    }

    /**
     * @see com.crosssolutions.user.service.IUserService#findById(java.lang.Long)
     */
    @Override
    @Transactional(readOnly = true)
    public UserDto findById(final Long id) {

        final Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return mapper.asUserDto(user.get());
        } else {
            throw new ElementNotFoundException(User.class, id);
        }
    }

    /**
     * @see com.crosssolutions.user.service.IUserService#save(com.crosssolutions.user.dto.UserDto)
     */
    @Override
    public Long save(final UserDto user) {

        final User entity = mapper.asUser(user);
        final List<Application> applications = appRepository.findAllById(user.getAppIds());

        entity.setActive(true);
        entity.setCreatedBy("Z.DRISSI");
        entity.setApplications(new HashSet<>(applications));

        repository.save(entity);

        final String token = tokenService.generateToken(entity);

        // Send activation mail
        eventPublisher.publishEvent(new OnSendActivationMailEvent(entity, token));

        return entity.getId();
    }

    /**
     * @see com.crosssolutions.user.service.IUserService#update(com.crosssolutions.user.dto.UserDto)
     */
    @Override
    public void update(final UserDto user) {

        final Optional<User> saved = repository.findById(user.getId());

        if (saved.isPresent()) {
            final User entity = saved.get();

            mapper.updateUserFromUserDto(user, entity);

            final List<Application> applications = appRepository.findAllById(user.getAppIds());

            entity.getApplications().clear();
            entity.getApplications().addAll(applications);

            repository.save(entity);
        } else {
            throw new ElementNotFoundException(User.class, user.getId());
        }
    }

    /**
     * @see com.crosssolutions.user.service.IUserService#updateUserStatus(UserDto)
     */
    @Override
    public void updateUserStatus(final UserDto user) {

        final Optional<User> savedUser = repository.findById(user.getId());

        if (savedUser.isPresent()) {
            final User content = savedUser.get();

            content.setActive(user.isActive());
        } else {
            throw new ElementNotFoundException(User.class, user.getId());
        }
    }

    /**
     * @see com.crosssolutions.user.service.IUserService#delete(java.lang.Long)
     */
    @Override
    public void delete(final Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ElementNotFoundException(User.class, id);
        }
    }

}
