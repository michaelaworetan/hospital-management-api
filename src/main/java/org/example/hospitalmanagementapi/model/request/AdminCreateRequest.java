package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminCreateRequest {
    private String adminName;
    private int adminHospitalId;
}
