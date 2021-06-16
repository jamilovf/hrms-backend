package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.dto.AdvertisementDto;
import com.jamilovf.hrms.entity.concretes.Advertisement;

import java.util.List;

public interface AdvertisementService {
    Result add(Advertisement advertisement);

    DataResult<List<AdvertisementDto>> getAllActiveAdvertisements();
}
