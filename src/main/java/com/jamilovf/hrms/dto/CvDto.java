package com.jamilovf.hrms.dto;

import com.jamilovf.hrms.entity.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CvDto {
    private Integer id;
    private String coverLetter;
    private Integer candidateId;
    private List<CvCandidateEducationDto> cvCandidateEducationDtoList;
    private List<CvCandidateExperienceDto> cvCandidateExperienceDtoList;
    private List<CvCandidateLanguageDto> cvCandidateLanguageDtoList;
    private List<CvCandidateTechnologyStackDto> cvCandidateTechnologyStackDtoList;
    private CvImageDto cvImageDto;
    private SocialMediaDetailsDto socialMediaDetailsDto;
}
