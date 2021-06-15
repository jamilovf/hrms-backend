package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.SalaryScale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryScaleDao extends JpaRepository<SalaryScale,Integer> {
}
