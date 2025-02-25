package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class StaffCreateRequest {
    private String staffName;
    private int staffHospitalId;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
}
