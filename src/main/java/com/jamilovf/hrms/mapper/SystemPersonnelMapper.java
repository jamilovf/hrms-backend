package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.SystemPersonnelDto;
import com.jamilovf.hrms.entity.concretes.SystemPersonnel;

public class SystemPersonnelMapper {
    public static SystemPersonnelDto entityToDto(SystemPersonnel systemPersonnel){
        return new SystemPersonnelDto()
                .setEmail(systemPersonnel.getEmail())
                .setPassword(systemPersonnel.getPassword())
                .setFirstName(systemPersonnel.getFirstName())
                .setLastName(systemPersonnel.getLastName());
    }

    public static SystemPersonnel dtoToEntity(SystemPersonnelDto systemPersonnelDto){
        SystemPersonnel systemPersonnel = new SystemPersonnel();
        systemPersonnel
                .setEmail(systemPersonnelDto.getEmail())
                .setPassword(systemPersonnelDto.getPassword());
        systemPersonnel
                .setFirstName(systemPersonnelDto.getFirstName())
                .setLastName(systemPersonnelDto.getLastName());

        return systemPersonnel;
    }
}
