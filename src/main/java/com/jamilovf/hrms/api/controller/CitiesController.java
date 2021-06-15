package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.CityService;
import com.jamilovf.hrms.core.utils.results.ErrorDataResult;
import com.jamilovf.hrms.entity.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/cities")
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody City city){
        return ResponseEntity.ok(this.cityService.add(city));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors =
                new ErrorDataResult<>(validationErrors,"Validation errors");
        return errors;
    }
}
