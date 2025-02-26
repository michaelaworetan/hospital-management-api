package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DoctorDetailsResponse {
    private String staffName;
    private int doctorStaffId;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
    private String doctorSpeciality;
}
