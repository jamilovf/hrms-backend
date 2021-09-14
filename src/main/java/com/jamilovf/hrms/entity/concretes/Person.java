package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Accessors(chain = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
@Table(name = "person")
public class Person {

    @Id
    @EqualsAndHashCode.Include
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

    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "email_verification_status")
    private Boolean emailVerificationStatus;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Notification> notificationList;

}
