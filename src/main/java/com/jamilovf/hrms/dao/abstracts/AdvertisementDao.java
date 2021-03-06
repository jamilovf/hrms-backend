package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.dto.AdvertisementDto;
import com.jamilovf.hrms.entity.concretes.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdvertisementDao extends JpaRepository<Advertisement,Integer> {

    @Query("Select new com.jamilovf.hrms.dto.AdvertisementDto(a.id,e.companyName,jp.position,a.openPositions,a.createdAt,a.applicationDeadline) From Advertisement a Inner Join a.employer e Inner Join a.jobPosition jp Where a.isActive = true")
    List<AdvertisementDto> getAllActiveAdvertisements();

    @Query("Select new com.jamilovf.hrms.dto.AdvertisementDto(a.id,e.companyName,jp.position,a.openPositions,a.createdAt,a.applicationDeadline) From Advertisement a Inner Join a.employer e Inner Join a.jobPosition jp Where a.isActive = true Order By a.createdAt Desc")
    List<AdvertisementDto> getAllActiveAdvertisementsSortedByDate();

    @Query("Select new com.jamilovf.hrms.dto.AdvertisementDto(a.id,e.companyName,jp.position,a.openPositions,a.createdAt,a.applicationDeadline) From Advertisement a Inner Join a.employer e Inner Join a.jobPosition jp Where a.isActive = true And e.id = :employerId")
    List<AdvertisementDto> getAllActiveAdvertisementsByEmployer(int employerId);

    @Modifying
    @Transactional
    @Query("Update Advertisement a Set a.isActive = :status Where a.id = :id")
    int changeAdvertisementStatus(boolean status, int id);
}
