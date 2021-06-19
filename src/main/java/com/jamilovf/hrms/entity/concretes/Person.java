package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email has to be present")
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @NotNull(message = "Password has to be present")
    @Column(name = "password")
    private String password;

}
