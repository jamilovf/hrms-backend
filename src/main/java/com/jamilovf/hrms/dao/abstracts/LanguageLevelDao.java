package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel,Integer> {
    List<LanguageLevel> findByLevelIn(List<Integer> levels);
}
