package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.AdvertisementService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.ErrorDataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.dto.AdvertisementDto;
import com.jamilovf.hrms.entity.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementsController {

    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementsController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Advertisement advertisement){
        return ResponseEntity.ok(this.advertisementService.add(advertisement));
    }

    @GetMapping("/getAllActiveAdvertisements")
    public ResponseEntity<?> getAllActiveAdvertisements(){
        return ResponseEntity.ok(this.advertisementService.getAllActiveAdvertisements());
    }

    @GetMapping("/getAllActiveAdvertisementsSortedByDate")
    public ResponseEntity<?> getAllActiveAdvertisementsSortedByDate(){
        return ResponseEntity.ok(this.advertisementService.getAllActiveAdvertisementsSortedByDate());
    }

    @GetMapping("/getAllActiveAdvertisementsByEmployer")
    public ResponseEntity<?> getAllActiveAdvertisementsByEmployer(@RequestParam int employerId){
        return ResponseEntity.ok(this.advertisementService.getAllActiveAdvertisementsByEmployer(employerId));
    }

    @PostMapping("/changeAdvertisementStatus")
    public ResponseEntity<?> changeAdvertisementStatus(@RequestParam  boolean status, @RequestParam int id){
        return ResponseEntity.ok(this.advertisementService.changeAdvertisementStatus(status,id));
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
