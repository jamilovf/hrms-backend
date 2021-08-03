package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.SchoolDto;
import com.jamilovf.hrms.entity.concretes.School;

public class SchoolMapper {
    public static SchoolDto entityToDto(School school){
        return new SchoolDto()
                .setId(school.getId())
                .setName(school.getName());
    }

    public static School dtoToEntity(SchoolDto schoolDto){
        return new School()
                .setId(schoolDto.getId())
                .setName(schoolDto.getName());
    }
}
