package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.dto.AdvertisementDto;
import com.jamilovf.hrms.entity.concretes.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementDao extends JpaRepository<Advertisement,Integer> {

    @Query("Select new com.jamilovf.hrms.dto.AdvertisementDto(a.id,e.companyName,jp.position,a.openPositions,a.createdAt,a.applicationDeadline) From Advertisement a Inner Join a.employer e Inner Join a.jobPosition jp where a.isActive = true")
    List<AdvertisementDto> getAllActiveAdvertisements();

    @Query("Select new com.jamilovf.hrms.dto.AdvertisementDto(a.id,e.companyName,jp.position,a.openPositions,a.createdAt,a.applicationDeadline) From Advertisement a Inner Join a.employer e Inner Join a.jobPosition jp where a.isActive = true Order By a.createdAt Desc")
    List<AdvertisementDto> getAllActiveAdvertisementsSortedByDate();
}
