package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.response.PrescriptionItemResponse;

import java.util.List;

@Data
@Builder
public class CustomPrescriptionItemListResponse {
    private String responseCode;
    private String responseMessage;
    private List<PrescriptionItemResponse> prescriptionItemResponses;
}
