package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorGetByIdResponse {
    private int doctorId;
    private int doctorStaffId;
    private String doctorName;
    private String doctorSpeciality;
    private String doctorLicenseNumber;
    private int doctorYearsExperience;
    private String doctorStatus;
    private String doctorCreatedAt;
    private String doctorUpdatedAt;
}
