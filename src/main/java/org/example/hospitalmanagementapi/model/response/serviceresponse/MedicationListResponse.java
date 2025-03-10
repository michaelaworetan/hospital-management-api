package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Medication;

import java.util.List;

@Data
@Builder
public class MedicationListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Medication> medications;
}
