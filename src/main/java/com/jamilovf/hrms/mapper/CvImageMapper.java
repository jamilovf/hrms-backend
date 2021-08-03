package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvImageDto;
import com.jamilovf.hrms.entity.concretes.CvImage;

public class CvImageMapper {
    public static CvImageDto entityToDto(CvImage cvImage){
        return new CvImageDto()
                .setId(cvImage.getId())
                .setUrl(cvImage.getUrl());
    }

    public static CvImage dtoToEntity(CvImageDto cvImageDto){
        return new CvImage()
                .setId(cvImageDto.getId())
                .setUrl(cvImageDto.getUrl());

    }
}
