package com.mongodb.frauddetection.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "FraudDetection")
public class FraudDetection {

    @Id
    private String id;

    private String type;
    private Double amount;
    private String nameOrig;
    private Double oldBalanceOrig;
    private Double newBalanceOrig;
    private Boolean isFraud;

}

