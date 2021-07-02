package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvCandidateEducationDto;
import com.jamilovf.hrms.entity.concretes.CvCandidateEducation;

public class CvCandidateEducationMapper {
    public static CvCandidateEducationDto entityToDto(CvCandidateEducation cvCandidateEducation){
        return new CvCandidateEducationDto()
                .setId(cvCandidateEducation.getId())
                .setSchool(cvCandidateEducation.getSchool())
                .setDepartment(cvCandidateEducation.getDepartment())
                .setEntryYear(cvCandidateEducation.getEntryYear())
                .setGraduateYear(cvCandidateEducation.getGraduateYear());
    }

    public static CvCandidateEducation dtoToEntity(CvCandidateEducationDto cvCandidateEducationDto){
        return new CvCandidateEducation()
                .setId(cvCandidateEducationDto.getId())
                .setSchool(cvCandidateEducationDto.getSchool())
                .setDepartment(cvCandidateEducationDto.getDepartment())
                .setEntryYear(cvCandidateEducationDto.getEntryYear())
                .setGraduateYear(cvCandidateEducationDto.getGraduateYear());
    }
}
