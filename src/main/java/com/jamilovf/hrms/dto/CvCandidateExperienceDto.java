package com.jamilovf.hrms.dto;

import com.jamilovf.hrms.entity.concretes.ExperienceCompany;
import com.jamilovf.hrms.entity.concretes.ExperiencePosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CvCandidateExperienceDto {
    private Integer id;
    private ExperienceCompany company;
    private ExperiencePosition position;
    private LocalDate entryYear;
    private LocalDate leavingYear;
}
