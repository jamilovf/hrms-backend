package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.PersonService;
import com.jamilovf.hrms.dao.abstracts.PersonDao;
import com.jamilovf.hrms.entity.concretes.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonManager implements PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonManager(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person getPerson(String email) {
        Person person = personDao.getByEmail(email);

        if (person == null)
            throw new UsernameNotFoundException(email);

        return person;
    }
}
