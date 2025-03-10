package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Medication;

@Data
@Builder
public class MedicationSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Medication medication;
}
