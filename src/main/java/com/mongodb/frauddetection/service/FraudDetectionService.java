package com.mongodb.frauddetection.service;

import com.mongodb.frauddetection.model.FraudDetection;
import com.mongodb.frauddetection.repository.FraudDetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudDetectionService {

    @Autowired
    private FraudDetectionRepository fraudDetectionRepository;


    public Page<FraudDetection> getAllFraudDetection(Pageable pageable){

        return fraudDetectionRepository.findAll(pageable);
    }

    public Page<List<FraudDetection>> getByType(String type, Pageable pageable){

        return fraudDetectionRepository.findByType(type, pageable);
    }

    public FraudDetection getByNameOrig(String nameOrig){

        return fraudDetectionRepository.findByNameOrig(nameOrig);
    }

    public void deleteByNameOrig(String nameOrig){

        fraudDetectionRepository.deleteByNameOrig(nameOrig);
    }

    public FraudDetection create(FraudDetection fraudDetection){

        return fraudDetectionRepository.save(fraudDetection);
    }

    public FraudDetection update(FraudDetection fraudDetection, String nameOrig){

        FraudDetection newFraudDetection = fraudDetectionRepository.findByNameOrig(nameOrig);

        fraudDetection.setId(newFraudDetection.getId());

        return fraudDetectionRepository.save(fraudDetection);

    }

}