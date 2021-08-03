package com.jamilovf.hrms.dto;

import com.jamilovf.hrms.entity.concretes.TechnologyStack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CvCandidateTechnologyStackDto {
    private Integer id;
    private TechnologyStackDto technologyStackDto;
}
