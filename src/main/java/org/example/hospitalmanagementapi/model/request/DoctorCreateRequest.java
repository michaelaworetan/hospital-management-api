package org.example.hospitalmanagementapi.model.request;

import lombok.Data;

@Data
public class DoctorCreateRequest {
    private int doctorStaffId;
    private String doctorName;
    private String doctorSpeciality;
    private String doctorLicenseNumber;
    private int doctorYearsExperience;
    private String doctorStatus;
    private String doctorCreatedAt;
}
