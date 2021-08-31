package com.jamilovf.hrms.core.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonLoginRequestModel {
    private String email;
    private String password;
}
