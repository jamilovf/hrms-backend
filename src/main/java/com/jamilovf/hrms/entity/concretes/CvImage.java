package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_image")

public class CvImage {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "url")
    private String url;

    @OneToOne(mappedBy = "cvImage")
    private Cv cv;

}
