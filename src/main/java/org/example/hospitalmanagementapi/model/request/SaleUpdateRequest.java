package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SaleUpdateRequest {
    private int salesId;
    private int salesPrescriptionId;
    private int salesQuantity;
    private BigDecimal salesTotalPrice;
    private String salesStatus;
}
