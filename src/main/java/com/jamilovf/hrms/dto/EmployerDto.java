package com.jamilovf.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmployerDto {
    private String email;
    private String password;
    private String passwordConfirmation;
    private String companyName;
    private String website;
    private String phoneNumber;

}
