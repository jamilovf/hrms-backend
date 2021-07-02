package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@Table(name = "cv_candidate_education")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvCandidateEducation {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entry_year")
    private LocalDate entryYear;

    @Column(name = "graduate_year")
    private LocalDate graduateYear;

    @JoinColumn(name = "department_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @JoinColumn(name = "school_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private School school;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

}
