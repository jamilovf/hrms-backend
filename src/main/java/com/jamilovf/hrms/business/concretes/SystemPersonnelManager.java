package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.SystemPersonnelService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessDataResult;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.SystemPersonnelDao;
import com.jamilovf.hrms.entity.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
        this.systemPersonnelDao = systemPersonnelDao;
    }

    @Override
    public Result add(SystemPersonnel systemPersonnel) {
        this.systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult("System Personnel is added: " + systemPersonnel.getFirstName() + " " + systemPersonnel.getLastName());
    }

    @Override
    public DataResult<List<SystemPersonnel>> getAll() {
        return new SuccessDataResult<>(this.systemPersonnelDao.findAll(),"All system personnel are listed");
    }
}
