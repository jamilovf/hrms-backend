package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technology_stack")
public class TechnologyStack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "technology_name")
    private String technologyName;

    @OneToMany(mappedBy = "technologyStack", cascade = CascadeType.ALL)
    private List<CvCandidateTechnologyStack> cvCandidateTechnologyStackList;

}
