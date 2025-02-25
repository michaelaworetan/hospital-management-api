package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorUpdateRequest {
    private int doctorId;
    private int doctorStaffId;
    private String doctorSpeciality;
    private String doctorLicenseNumber;
    private int doctorYearsExperience;
    private String doctorStatus;
}
