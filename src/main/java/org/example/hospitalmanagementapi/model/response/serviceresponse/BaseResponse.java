package org.example.hospitalmanagementapi.model.response.serviceresponse;

import lombok.Builder;
import lombok.Data;

@Data
public class BaseResponse {
    private String responseCode;
    private String responseMessage;

    public BaseResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public BaseResponse(){

    }
}
