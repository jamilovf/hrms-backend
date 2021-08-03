package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.ExperiencePositionDto;
import com.jamilovf.hrms.entity.concretes.ExperiencePosition;

public class ExperiencePositionMapper {
    public static ExperiencePositionDto entityToDto(ExperiencePosition experiencePosition){
        return new ExperiencePositionDto()
                .setId(experiencePosition.getId())
                .setName(experiencePosition.getName());
    }

    public static ExperiencePosition dtoToEntity(ExperiencePositionDto experiencePositionDto){
        return new ExperiencePosition()
                .setId(experiencePositionDto.getId())
                .setName(experiencePositionDto.getName());
    }
}
