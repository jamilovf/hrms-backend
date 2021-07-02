package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@Table(name = "cv_candidate_technology_stack")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvCandidateTechnologyStack {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "technology_stack_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private TechnologyStack technologyStack;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

}
