package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvCandidateExperienceDto;
import com.jamilovf.hrms.entity.concretes.CvCandidateExperience;

public class CvCandidateExperienceMapper {
    public static CvCandidateExperienceDto entityToDto(CvCandidateExperience cvCandidateExperience){
        return new CvCandidateExperienceDto()
                .setId(cvCandidateExperience.getId())
                .setCompany(cvCandidateExperience.getCompany())
                .setPosition(cvCandidateExperience.getPosition())
                .setEntryYear(cvCandidateExperience.getEntryYear())
                .setLeavingYear(cvCandidateExperience.getLeavingYear());
    }

    public static CvCandidateExperience dtoToEntity(CvCandidateExperienceDto cvCandidateExperienceDto){
        return new CvCandidateExperience()
                .setId(cvCandidateExperienceDto.getId())
                .setCompany(cvCandidateExperienceDto.getCompany())
                .setPosition(cvCandidateExperienceDto.getPosition())
                .setEntryYear(cvCandidateExperienceDto.getEntryYear())
                .setLeavingYear(cvCandidateExperienceDto.getLeavingYear());
    }
}
