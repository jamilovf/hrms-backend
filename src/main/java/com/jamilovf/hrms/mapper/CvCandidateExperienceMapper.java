package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvCandidateExperienceDto;
import com.jamilovf.hrms.entity.concretes.CvCandidateExperience;

public class CvCandidateExperienceMapper {
    public static CvCandidateExperienceDto entityToDto(CvCandidateExperience cvCandidateExperience){
        return new CvCandidateExperienceDto()
                .setId(cvCandidateExperience.getId())
                .setExperienceCompanyDto(ExperienceCompanyMapper.entityToDto(cvCandidateExperience.getExperienceCompany()))
                .setExperiencePositionDto(ExperiencePositionMapper.entityToDto(cvCandidateExperience.getExperiencePosition()))
                .setEntryYear(cvCandidateExperience.getEntryYear())
                .setLeavingYear(cvCandidateExperience.getLeavingYear());
    }

    public static CvCandidateExperience dtoToEntity(CvCandidateExperienceDto cvCandidateExperienceDto){
        return new CvCandidateExperience()
                .setId(cvCandidateExperienceDto.getId())
                .setExperienceCompany(ExperienceCompanyMapper.dtoToEntity(cvCandidateExperienceDto.getExperienceCompanyDto()))
                .setExperiencePosition(ExperiencePositionMapper.dtoToEntity(cvCandidateExperienceDto.getExperiencePositionDto()))
                .setEntryYear(cvCandidateExperienceDto.getEntryYear())
                .setLeavingYear(cvCandidateExperienceDto.getLeavingYear());
    }
}
