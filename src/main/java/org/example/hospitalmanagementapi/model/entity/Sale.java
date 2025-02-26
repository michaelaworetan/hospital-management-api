package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Sale {
    private int salesId;
    private int saleHospitalId;
    private int salesPrescriptionId;
    private int salesQuantity;
    private BigDecimal salesTotalPrice;
    private String salesStatus;
    private String salesCreatedAt;
    private String salesUpdatedAt;
}
