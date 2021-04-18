package com.crosssolutions.user.mapper;

import com.crosssolutions.user.domain.VerificationToken;
import com.crosssolutions.user.dto.VerificationTokenDto;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface IVerificationMapper {

    /**
     * Converts the entity to a dto
     * 
     * @param entity
     *            the verification token
     * @return the data object
     */
    @Maps(withCustomFields = @Field({ "email", "user.email" }))
    VerificationTokenDto asVerificationTokenDto(VerificationToken entity);
}
