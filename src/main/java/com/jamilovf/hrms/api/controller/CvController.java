package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.CvService;
import com.jamilovf.hrms.dto.CvDto;
import com.jamilovf.hrms.entity.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CvDto cvDto){
        System.err.println(cvDto);
        return ResponseEntity.ok(this.cvService.add(cvDto));
    }
}
