package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Equipment;

import java.util.List;

public interface EquipmentRepository {
    List<Equipment> getAllEquipments();

    Equipment getEquipmentById(int equipmentId);

    List<Equipment> getEquipmentsByHospitalId(int hospitalId);

    int createEquipment(Equipment equipment);

    int updateEquipment(Equipment equipment);

    int deleteEquipmentById(int equipmentId);
}
