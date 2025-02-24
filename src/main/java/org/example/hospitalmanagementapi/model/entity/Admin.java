package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {
    private int adminId;
    private String adminName;
    private int adminHospitalId;
    private String adminStatus;
    private String adminCreatedAt;
    private String adminUpdatedAt;
}
