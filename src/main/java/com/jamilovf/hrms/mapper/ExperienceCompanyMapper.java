package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.ExperienceCompanyDto;
import com.jamilovf.hrms.entity.concretes.ExperienceCompany;

public class ExperienceCompanyMapper {
    public static ExperienceCompanyDto entityToDto(ExperienceCompany experienceCompany){
        return new ExperienceCompanyDto()
                .setId(experienceCompany.getId())
                .setName(experienceCompany.getName());
    }

    public static ExperienceCompany dtoToEntity(ExperienceCompanyDto experienceCompanyDto){
        return new ExperienceCompany()
                .setId(experienceCompanyDto.getId())
                .setName(experienceCompanyDto.getName());
    }
}
