package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.AdvertisementDto;
import com.jamilovf.hrms.entity.concretes.Advertisement;

public class AdvertisementMapper {
    public static AdvertisementDto toAdvertisementDto(Advertisement advertisement){
        return new AdvertisementDto()
                .setId(advertisement.getId())
                .setCompanyName(advertisement.getEmployer().getCompanyName())
                .setJobPosition(advertisement.getJobPosition().getPosition())
                .setOpenPositions(advertisement.getOpenPositions())
                .setCreatedAt(advertisement.getCreatedAt())
                .setApplicationDeadline(advertisement.getApplicationDeadline());
    }
}
