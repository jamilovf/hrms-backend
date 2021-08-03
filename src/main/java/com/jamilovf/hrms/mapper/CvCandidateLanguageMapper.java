package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvCandidateLanguageDto;
import com.jamilovf.hrms.entity.concretes.CvCandidateLanguage;

public class CvCandidateLanguageMapper {
    public static CvCandidateLanguageDto entityToDto(CvCandidateLanguage cvCandidateLanguage){
        return new CvCandidateLanguageDto()
                .setId(cvCandidateLanguage.getId())
                .setLanguageDto(LanguageMapper.entityToDto(cvCandidateLanguage.getLanguage()))
                .setLanguageLevelDto(LanguageLevelMapper.entityToDto(cvCandidateLanguage.getLanguageLevel()));
    }

    public static CvCandidateLanguage dtoToEntity(CvCandidateLanguageDto cvCandidateLanguageDto){
        return new CvCandidateLanguage()
                .setId(cvCandidateLanguageDto.getId())
                .setLanguage(LanguageMapper.dtoToEntity(cvCandidateLanguageDto.getLanguageDto()))
                .setLanguageLevel(LanguageLevelMapper.dtoToEntity(cvCandidateLanguageDto.getLanguageLevelDto()));
    }
}
