package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
