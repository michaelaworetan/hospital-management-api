package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalUpdateRequest {
    private int hospitalId;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalContactNo;
    private String hospitalEmail;
    private String hospitalStatus;
}
