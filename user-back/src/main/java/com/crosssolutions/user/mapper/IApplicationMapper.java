package com.crosssolutions.user.mapper;

import java.util.List;

import com.bycnit.lap.domain.Application;
import com.bycnit.lap.dto.ApplicationDto;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface IApplicationMapper {

    /**
     * Converts a list of entities to a list of dtos
     *
     * @param applications
     * @return list of dtos
     */
    List<ApplicationDto> asApplications(List<Application> applications);

    ApplicationDto asApplicationDto(Application application);

    Application asApplication(ApplicationDto application);

    @Maps(withIgnoreFields = "appId")
    Application updateApplicationFromApplicationDto(ApplicationDto source, Application destination);
}
