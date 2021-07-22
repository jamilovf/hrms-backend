package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "job_position")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisementList"})
public class JobPosition {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Position is mandatory")
    @NotNull(message = "Position has to be present")
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "jobPosition")
    private List<Advertisement> advertisementList;
}
