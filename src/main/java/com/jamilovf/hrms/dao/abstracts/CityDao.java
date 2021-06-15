package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
