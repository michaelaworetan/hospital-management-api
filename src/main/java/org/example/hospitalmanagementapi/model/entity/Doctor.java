package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Doctor {
    private int doctorId;
    private int doctorStaffId;
    private String doctorSpeciality;
    private String doctorLicenseNumber;
    private int doctorYearsExperience;
    private String doctorStatus;
    private String doctorCreatedAt;
    private String doctorUpdatedAt;
}
