package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Sale;

import java.util.List;

@Data
@Builder
public class SaleListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Sale> sales;
}
