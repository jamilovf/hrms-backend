package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
