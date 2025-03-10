package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Equipment;
import org.example.hospitalmanagementapi.model.request.EquipmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.EquipmentUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.EquipmentListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.EquipmentSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.EquipmentRepository;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

        private final HospitalRepository hospitalRepository;


    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository , HospitalRepository hospitalRepository) {
        this.equipmentRepository = equipmentRepository;
                this.hospitalRepository = hospitalRepository;
    }

    public EquipmentListResponse getAllEquipments() {
        var equipments = equipmentRepository.getAllEquipments();

        return EquipmentListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .equipments(equipments)
                .build();
    }

    public EquipmentSingleResponse getEquipmentById(int equipmentId) {
        var equipment =  equipmentRepository.getEquipmentById(equipmentId);

        return EquipmentSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .equipment(equipment)
                .build();
    }

    public EquipmentListResponse getEquipmentsByHospitalId(int hospitalId) {
        var equipments =  equipmentRepository.getEquipmentsByHospitalId(hospitalId);

        return EquipmentListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .equipments(equipments)
                .build();
    }

    public BaseResponse createEquipment(EquipmentCreateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getEquipmentHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }
        var equipment = gson.fromJson(gson.toJson(request), Equipment.class);
        equipmentRepository.createEquipment(equipment);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateEquipment(EquipmentUpdateRequest request) {
        Gson gson = new Gson();
        var equipmentResponse = equipmentRepository.getEquipmentById(request.getEquipmentId());
        if(equipmentResponse == null){
            return new BaseResponse("106", "Equipment not found");
        }
        var hospital = hospitalRepository.getHospitalById(request.getEquipmentHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }
        var equipment = gson.fromJson(gson.toJson(request), Equipment.class);
        equipmentRepository.updateEquipment(equipment);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteEquipmentById(int equipmentId) {
        equipmentRepository.deleteEquipmentById(equipmentId);
        return ResponseConstants.SUCCESS;
    }
}