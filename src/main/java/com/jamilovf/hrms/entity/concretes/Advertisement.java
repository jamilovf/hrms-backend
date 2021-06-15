package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "advertisement")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "salary_scale_id")
    private SalaryScale salaryScale;

    @NotBlank(message = "Job description is mandatory")
    @NotNull(message = "Job description has to be present")
    @Column(name = "job_description")
    private String jobDescription;

    @NotNull(message = "Open positions have to be present")
    @Column(name = "open_positions")
    private int openPositions;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "application_date")
    private LocalDate applicationDeadline;

    @Column(name = "is_active")
    private boolean isActive;
}
