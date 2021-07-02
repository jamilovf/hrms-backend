package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvCandidateLanguageDto;
import com.jamilovf.hrms.entity.concretes.CvCandidateLanguage;

public class CvCandidateLanguageMapper {
    public static CvCandidateLanguageDto entityToDto(CvCandidateLanguage cvCandidateLanguage){
        return new CvCandidateLanguageDto()
                .setId(cvCandidateLanguage.getId())
                .setLanguage(cvCandidateLanguage.getLanguage())
                .setLanguageLevel(cvCandidateLanguage.getLanguageLevel());
    }

    public static CvCandidateLanguage dtoToEntity(CvCandidateLanguageDto cvCandidateLanguageDto){
        return new CvCandidateLanguage()
                .setId(cvCandidateLanguageDto.getId())
                .setLanguage(cvCandidateLanguageDto.getLanguage())
                .setLanguageLevel(cvCandidateLanguageDto.getLanguageLevel());
    }
}
