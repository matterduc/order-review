package com.crosssolutions.user.mapper;

import com.crosssolutions.user.domain.Application;
import com.crosssolutions.user.domain.User;
import com.crosssolutions.user.dto.ApplicationDto;
import com.crosssolutions.user.dto.UserDto;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface IUserMapper {

    /**
     * Converts a user entity to a DTO
     *
     * @param user
     *            a user
     * @return a dto
     */
    UserDto asUserDto(User user);

    /**
     * Converts a user DTO to an entity
     *
     * @param user
     *            a user
     * @return an entity
     */
    User asUser(UserDto user);

    @Maps(withIgnoreFields = { "id", "applications" })
    User updateUserFromUserDto(UserDto source, User destination);

    @Maps(withIgnoreFields = { "appId", "description", "name" })
    Application asApplication(ApplicationDto inApplicationDto);

    @Maps(withIgnoreFields = { "appId", "description" })
    ApplicationDto asApplicationDto(Application inApplication);
}
