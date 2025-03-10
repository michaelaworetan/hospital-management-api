package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.response.MedicationResponse;

import java.util.List;

@Data
@Builder
public class CustomMedicationListResponse {
    private String responseCode;
    private String responseMessage;
    private List<MedicationResponse> medications;
}
