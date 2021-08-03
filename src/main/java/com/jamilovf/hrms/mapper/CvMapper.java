package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvDto;
import com.jamilovf.hrms.entity.concretes.Cv;

import java.util.stream.Collectors;

public class CvMapper {
    public static CvDto entityToDto(Cv cv){
        CvDto cvDto = new CvDto()
                .setId(cv.getId())
                .setCandidateId(cv.getCandidate().getId())
                .setCoverLetter(cv.getCoverLetter())
                .setCvImageDto(CvImageMapper.entityToDto(cv.getCvImage()))
                .setSocialMediaDetailsDto(SocialMediaDetailsMapper.entityToDto(cv.getSocialMediaDetails()));

                cvDto.setCvCandidateEducationDtoList(cv.getCvCandidateEducationList().stream()
                                               .map(c -> CvCandidateEducationMapper.entityToDto(c))
                                               .collect(Collectors.toList()));

                cvDto.setCvCandidateExperienceDtoList(cv.getCvCandidateExperienceList().stream()
                                               .map(c -> CvCandidateExperienceMapper.entityToDto(c))
                                               .collect(Collectors.toList()));

                cvDto.setCvCandidateLanguageDtoList(cv.getCvCandidateLanguageList().stream()
                                               .map(c -> CvCandidateLanguageMapper.entityToDto(c))
                                               .collect(Collectors.toList()));

                cvDto.setCvCandidateTechnologyStackDtoList(cv.getCvCandidateTechnologyStackList().stream()
                                               .map(c -> CvCandidateTechnologyStackMapper.entityToDto(c))
                                               .collect(Collectors.toList()));

                return cvDto;
    }

    public static Cv dtoToEntity(CvDto cvDto){
        Cv cv = new Cv()
                .setId(cvDto.getId())
                .setCoverLetter(cvDto.getCoverLetter())
                .setCvImage(CvImageMapper.dtoToEntity(cvDto.getCvImageDto()))
                .setSocialMediaDetails(SocialMediaDetailsMapper.dtoToEntity(cvDto.getSocialMediaDetailsDto()));

        cv.setCvCandidateEducationList(cvDto.getCvCandidateEducationDtoList().stream()
                .map(c -> CvCandidateEducationMapper.dtoToEntity(c))
                .collect(Collectors.toList()));

        cv.setCvCandidateExperienceList(cvDto.getCvCandidateExperienceDtoList().stream()
                .map(c -> CvCandidateExperienceMapper.dtoToEntity(c))
                .collect(Collectors.toList()));

        cv.setCvCandidateLanguageList(cvDto.getCvCandidateLanguageDtoList().stream()
                .map(c -> CvCandidateLanguageMapper.dtoToEntity(c))
                .collect(Collectors.toList()));

        cv.setCvCandidateTechnologyStackList(cvDto.getCvCandidateTechnologyStackDtoList().stream()
                .map(c -> CvCandidateTechnologyStackMapper.dtoToEntity(c))
                .collect(Collectors.toList()));

        return cv;
    }
}
