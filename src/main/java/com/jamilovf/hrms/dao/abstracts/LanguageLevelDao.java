package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel,Integer> {
    LanguageLevel findByLevel(Integer level);
}
