package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.EmployerDto;
import com.jamilovf.hrms.entity.concretes.Employer;

public class EmployerMapper {
    public static EmployerDto entityToDto(Employer employer){
        return new EmployerDto()
                .setEmail(employer.getEmail())
                .setPassword(employer.getPassword())
                .setCompanyName(employer.getCompanyName())
                .setWebsite(employer.getWebsite())
                .setPhoneNumber(employer.getPhoneNumber());

    }

    public static Employer dtoToEntity(EmployerDto employerDto){
        Employer employer = new Employer();
        employer
                .setEmail(employerDto.getEmail())
                .setPassword(employerDto.getPassword());
        employer
                .setCompanyName(employerDto.getCompanyName())
                .setWebsite(employerDto.getWebsite())
                .setPhoneNumber(employerDto.getPhoneNumber());

        return employer;
    }
}
