package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Prescription;

import java.util.List;

@Data
@Builder
public class PrescriptionListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Prescription> prescriptions;
}
