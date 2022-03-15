package com.mongodb.frauddetection.controller;

import com.mongodb.frauddetection.model.FraudDetection;
import com.mongodb.frauddetection.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/fraudDetection")
@RestController
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @GetMapping("/")
    public ResponseEntity<Page<FraudDetection>> getAllFraudDetection(@PageableDefault(page = 0,
            size = 50) Pageable pageable){

        Page<FraudDetection> fraudDetection = fraudDetectionService.getAllFraudDetection(pageable);
        return new ResponseEntity<>(fraudDetection, fraudDetection == null  || fraudDetection.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping(value = {"type/{type}"})
    public ResponseEntity<Page<List<FraudDetection>>> getByType(@PathVariable String type, @PageableDefault(page = 0,
            size = 50) Pageable pageable){

        Page<List<FraudDetection>> fraudDetection = fraudDetectionService.getByType(type, pageable);
        return new ResponseEntity<>(fraudDetection, fraudDetection == null  || fraudDetection.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping(value = {"nameOrig/{nameOrig}"})
    public ResponseEntity<FraudDetection> getByNameOrig(@PathVariable String nameOrig){

        FraudDetection fraudDetection = fraudDetectionService.getByNameOrig(nameOrig);
        return new ResponseEntity<>(fraudDetection, fraudDetection == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @DeleteMapping(value = "/{nameOrig}")
    public ResponseEntity<List<FraudDetection>> deleteByNameOrig(@PathVariable String nameOrig){

        fraudDetectionService.deleteByNameOrig(nameOrig);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<FraudDetection> add(@RequestBody FraudDetection fraudDetection){

       return new ResponseEntity<>(fraudDetectionService.create(fraudDetection), HttpStatus.OK);
    }

    @PutMapping(value="/{nameOrig}")
    public ResponseEntity<FraudDetection> update(@RequestBody FraudDetection fraudDetection, @PathVariable String nameOrig){

        return new ResponseEntity<>(fraudDetectionService.update(fraudDetection, nameOrig), HttpStatus.OK);
    }

}