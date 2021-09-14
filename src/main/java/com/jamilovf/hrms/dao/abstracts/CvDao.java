package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDao extends JpaRepository<Cv,Integer> {
    //Cv getByCandidateId(Integer id);
}
