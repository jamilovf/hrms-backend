package com.jamilovf.hrms.dto;

import com.jamilovf.hrms.entity.concretes.Department;
import com.jamilovf.hrms.entity.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CvCandidateEducationDto {
    private Integer id;
    private SchoolDto schoolDto;
    private DepartmentDto departmentDto;
    private LocalDate entryYear;
    private LocalDate graduateYear;
}
