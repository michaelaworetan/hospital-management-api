package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Prescription;

@Data
@Builder
public class PrescriptionSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Prescription prescription;
}
