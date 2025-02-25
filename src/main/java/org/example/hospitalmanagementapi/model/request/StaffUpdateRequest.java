package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class StaffUpdateRequest {
    private int staffId;
    private int staffHospitalId;
    private String staffName;
    private String staffPosition;
    private String staffDepartment;
    private BigDecimal staffSalary;
    private String staffStatus;
}
