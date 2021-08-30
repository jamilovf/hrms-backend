package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@PrimaryKeyJoinColumn(name = "person_id")
@Accessors(chain = true)
@Table(name = "employer")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisementList"})
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

    @OneToMany(mappedBy = "employer")
    private List<Advertisement> advertisementList;

}