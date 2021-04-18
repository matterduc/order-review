package com.crosssolutions.user.mapper;

import com.bycnit.lap.domain.MasterKeyUser;
import com.bycnit.lap.security.JwtUser;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * @author Duc.Nguyen
 *
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface IMasterKeyUserMapper {

    /**
     * Maps a MasterKey User to a JwtUser
     *
     * @param user
     *            MK User
     * @return a jwt user
     */
    JwtUser asJwtUser(MasterKeyUser user);
}
