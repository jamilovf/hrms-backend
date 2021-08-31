package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {
    SystemPersonnel getByEmail(String email);
}
