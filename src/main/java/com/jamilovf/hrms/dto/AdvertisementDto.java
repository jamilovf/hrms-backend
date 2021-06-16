package com.jamilovf.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdvertisementDto {
    private int id;
    private String companyName;
    private String jobPosition;
    private int openPositions;
    private LocalDate createdAt;
    private LocalDate applicationDeadline;
}
