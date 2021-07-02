package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "employer")
public class Employer extends Person {

    @NotBlank(message = "Company name is mandatory")
    @NotNull(message = "Company name has to be present")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Website domain is mandatory")
    @NotNull(message = "Website domain has to be present")
    @Column(name = "website")
    private String website;

    @NotBlank(message = "Phone number is mandatory")
    @NotNull(message = "Phone number has to be present")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_verified")
    private boolean isVerified;

}