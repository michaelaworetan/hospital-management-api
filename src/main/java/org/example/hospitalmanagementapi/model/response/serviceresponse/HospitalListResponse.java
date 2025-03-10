package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.entity.Hospital;

import java.util.List;

@Data
@Builder
public class HospitalListResponse {
    private String responseCode;
    private String responseMessage;
    private List<Hospital> hsopitals;
}
