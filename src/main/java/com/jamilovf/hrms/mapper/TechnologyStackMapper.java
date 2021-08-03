package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.TechnologyStackDto;
import com.jamilovf.hrms.entity.concretes.TechnologyStack;

public class TechnologyStackMapper {
    public static TechnologyStackDto entityToDto(TechnologyStack technologyStack){
        return new TechnologyStackDto()
                .setId(technologyStack.getId())
                .setTechnologyName(technologyStack.getTechnologyName());
    }

    public static TechnologyStack dtoToEntity(TechnologyStackDto technologyStackDto){
        return new TechnologyStack()
                .setId(technologyStackDto.getId())
                .setTechnologyName(technologyStackDto.getTechnologyName());

    }
}
