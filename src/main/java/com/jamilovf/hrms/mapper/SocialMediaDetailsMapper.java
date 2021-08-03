package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.SocialMediaDetailsDto;
import com.jamilovf.hrms.entity.concretes.SocialMediaDetails;

public class SocialMediaDetailsMapper {
    public static SocialMediaDetailsDto entityToDto(SocialMediaDetails socialMediaDetails){
        return new SocialMediaDetailsDto()
                .setId(socialMediaDetails.getId())
                .setGithubUrl(socialMediaDetails.getGithubUrl())
                .setLinkedinUrl(socialMediaDetails.getLinkedinUrl());
    }

    public static SocialMediaDetails dtoToEntity(SocialMediaDetailsDto socialMediaDetailsDto){
        return new SocialMediaDetails()
                .setId(socialMediaDetailsDto.getId())
                .setGithubUrl(socialMediaDetailsDto.getGithubUrl())
                .setLinkedinUrl(socialMediaDetailsDto.getLinkedinUrl());

    }
}
