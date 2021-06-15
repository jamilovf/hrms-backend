package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @Column(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @Column(name = "city_id")
    private City city;

    @ManyToOne
    @Column(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @Column(name = "salary_scale_id")
    private SalaryScale salaryScale;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "open_positions")
    private int openPositions;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "application_date")
    private LocalDate applicationDeadline;

    @Column(name = "is_active")
    private boolean isActive;
}
