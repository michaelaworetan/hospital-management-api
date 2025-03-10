package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;
import org.example.hospitalmanagementapi.model.response.DoctorDetailsResponse;

import java.util.List;

@Data
@Builder
public class DoctorDetailsListResponse {
    private String responseCode;
    private String responseMessage;
    private List<DoctorDetailsResponse> detailsResponses;
}
