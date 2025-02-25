package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminUpdateRequest {
    private int adminId;
    private String adminName;
    private int adminHospitalId;
    private String adminStatus;
}
