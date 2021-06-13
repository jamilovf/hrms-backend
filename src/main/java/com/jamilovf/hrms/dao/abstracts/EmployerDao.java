package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
