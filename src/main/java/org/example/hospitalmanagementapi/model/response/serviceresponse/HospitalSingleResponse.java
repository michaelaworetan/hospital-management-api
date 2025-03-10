package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Hospital;

@Data
@Builder
public class HospitalSingleResponse {
    private String responseCode;
    private String responseMessage;
    private Hospital hospital;
}
