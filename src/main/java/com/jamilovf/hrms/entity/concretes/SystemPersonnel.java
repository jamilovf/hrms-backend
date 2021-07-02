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
@Table(name = "system_personnel")
public class SystemPersonnel extends Person{

    @NotBlank(message = "First name is mandatory")
    @NotNull(message = "First name has to be present")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @NotNull(message = "Last name has to be present")
    @Column(name = "last_name")
    private String lastName;

}
