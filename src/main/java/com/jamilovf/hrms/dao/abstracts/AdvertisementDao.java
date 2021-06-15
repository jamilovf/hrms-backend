package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementDao extends JpaRepository<Advertisement,Integer> {
}
