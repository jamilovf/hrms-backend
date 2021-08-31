package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer> {
    Person getByEmailVerificationToken(String token);
    Person getByEmail(String email);
}
