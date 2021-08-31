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
public class CandidateDto {
    private String email;
    private String password;
    private String passwordConfirmation;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private LocalDate birthDate;
}
