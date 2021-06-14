package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition getByPosition(String position);
}
