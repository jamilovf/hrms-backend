package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.AdvertisementService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessDataResult;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.AdvertisementDao;
import com.jamilovf.hrms.dao.abstracts.EmployerDao;
import com.jamilovf.hrms.dto.AdvertisementDto;
import com.jamilovf.hrms.entity.concretes.Advertisement;
import com.jamilovf.hrms.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertisementManager implements AdvertisementService {

    private AdvertisementDao advertisementDao;
    private EmployerDao employerDao;

    @Autowired
    public AdvertisementManager(AdvertisementDao advertisementDao, EmployerDao employerDao) {
        this.advertisementDao = advertisementDao;
        this.employerDao = employerDao;
    }

    @Override
    public Result add(Advertisement advertisement) {
        Employer employer = employerDao.getById(advertisement.getEmployer().getId());
        this.advertisementDao.save(advertisement);
        return new SuccessResult("Advertisement is added by " + employer.getCompanyName());
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAllActiveAdvertisements() {
        return new SuccessDataResult<>(this.advertisementDao.getAllActiveAdvertisements(),
                "All active advertisements are listed");
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAllActiveAdvertisementsSortedByDate() {
        return new SuccessDataResult<>(this.advertisementDao.getAllActiveAdvertisementsSortedByDate(),
                "All active advertisements are listed by release date");
    }

    @Override
    public DataResult<List<AdvertisementDto>> getAllActiveAdvertisementsByEmployer(int employerId) {
        List<AdvertisementDto> advertisementDtoList =
                this.advertisementDao.getAllActiveAdvertisementsByEmployer(employerId);

        if (advertisementDtoList.isEmpty()){
            return new SuccessDataResult<>(advertisementDtoList,
                    "There are no active advertisements for this company");
        }
        return new SuccessDataResult<>(advertisementDtoList,
                "All active advertisements of this company are listed");
    }

    @Override
    public Result changeAdvertisementStatus(boolean status, int id) {
        this.advertisementDao.changeAdvertisementStatus(status,id);
        return new SuccessResult("Advertisement status is updated");
    }

}
