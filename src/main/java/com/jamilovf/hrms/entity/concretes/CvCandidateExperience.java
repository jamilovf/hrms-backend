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
@Table(name = "cv_candidate_experience")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvCandidateExperience {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entry_year")
    private LocalDate entryYear;

    @Column(name = "leaving_year")
    private LocalDate leavingYear;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

    @JoinColumn(name = "company_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private ExperienceCompany experienceCompany;

    @JoinColumn(name = "position_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private ExperiencePosition experiencePosition;

}

