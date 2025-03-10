package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DoctorCreateRequest {
    private String doctorSpeciality;
    private String doctorLicenseNumber;
    private int doctorYearsExperience;
    private int staffHospitalId;
    private String staffName;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
}
