package com.mongodb.frauddetection.repository;

import com.mongodb.frauddetection.model.FraudDetection;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudDetectionRepository extends MongoRepository<FraudDetection, ObjectId> {

    //@Query(fields="{'pageable':0 }")
    Page<List<FraudDetection>> findByType(String type, Pageable pageable);

    FraudDetection findByNameOrig(String nameOrig);

    @DeleteQuery
    void deleteByNameOrig(String nameOrig);


}

