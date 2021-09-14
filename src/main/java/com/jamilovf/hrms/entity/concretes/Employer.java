package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONObject;

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
@TypeDef(name = "json", typeClass = JsonType.class)
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


    @Type(type = "json")
    @Column(name= "updated_fields")
    private String updatedFields;

    @OneToMany(mappedBy = "employer")
    private List<Advertisement> advertisementList;

}