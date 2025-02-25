package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Equipment;
import org.example.hospitalmanagementapi.model.request.EquipmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.EquipmentUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    //    private final HospitalRepository hospitalRepository;


    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository /*, HospitalRepository hospitalRepository*/) {
        this.equipmentRepository = equipmentRepository;
        //        this.hospitalRepository = hospitalRepository;
    }

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.getAllEquipments();
    }

    public Equipment getEquipmentById(int equipmentId) {
        return equipmentRepository.getEquipmentById(equipmentId);
    }

    public int createEquipment(EquipmentCreateRequest request) {
        Gson gson = new Gson();
        //        var hospital = hospitalRepository.getHospitalById(request.getAdminHospitalId());
//        if (hospital == null) {
//            return -1;
//        }
        var equipment = gson.fromJson(gson.toJson(request), Equipment.class);
        return equipmentRepository.createEquipment(equipment);
    }

    public int updateEquipment(EquipmentUpdateRequest request) {
        Gson gson = new Gson();
        //        var hospital = hospitalRepository.getHospitalById(request.getAdminHospitalId());
//        if (hospital == null) {
//            return -1;
//        }
        var equipment = gson.fromJson(gson.toJson(request), Equipment.class);
        return equipmentRepository.updateEquipment(equipment);
    }

    public int deleteEquipmentById(int equipmentId) {
        return equipmentRepository.deleteEquipmentById(equipmentId);
    }
}