package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CvCandidateTechnologyStackDto;
import com.jamilovf.hrms.entity.concretes.CvCandidateTechnologyStack;

public class CvCandidateTechnologyStackMapper {
    public static CvCandidateTechnologyStackDto entityToDto(CvCandidateTechnologyStack cvCandidateTechnologyStack){
        return new CvCandidateTechnologyStackDto()
                .setId(cvCandidateTechnologyStack.getId())
                .setTechnologyStack(cvCandidateTechnologyStack.getTechnologyStack());
    }

    public static CvCandidateTechnologyStack dtoToEntity(CvCandidateTechnologyStackDto cvCandidateTechnologyStackDto){
        return new CvCandidateTechnologyStack()
                .setId(cvCandidateTechnologyStackDto.getId())
                .setTechnologyStack(cvCandidateTechnologyStackDto.getTechnologyStack());
    }
}
