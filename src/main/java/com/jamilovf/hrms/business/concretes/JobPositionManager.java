package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.JobPositionService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessDataResult;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.JobPositionDao;
import com.jamilovf.hrms.entity.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position is added: " + jobPosition.getPosition());
    }

    @Override
    public Result update(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position is updated: " + jobPosition.getPosition());
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult("Job position is deleted: " + jobPosition.getPosition());
    }

    @Override
    public DataResult<JobPosition> getByPosition(String position) {
        return new SuccessDataResult<>(this.jobPositionDao.getByPosition(position),"Job position is gotten");
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(),"All job positions are listed");
    }
}
