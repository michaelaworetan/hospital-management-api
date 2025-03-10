package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Sale;

@Data
@Builder
public class SaleSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Sale sale;
}
