package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.entity.concretes.Person;

public interface PersonService {
    Person getPerson(String email);
}
