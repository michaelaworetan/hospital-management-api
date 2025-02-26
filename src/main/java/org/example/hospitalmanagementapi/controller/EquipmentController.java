package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.EquipmentService;
import org.example.hospitalmanagementapi.model.entity.Equipment;
import org.example.hospitalmanagementapi.model.request.EquipmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.EquipmentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping("/create-equipment")
    public ResponseEntity<String> createEquipment(@RequestBody EquipmentCreateRequest request) {
        var resp = equipmentService.createEquipment(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Equipment failed to create");
        return ResponseEntity.ok("Equipment created successfully");
    }

    @GetMapping("/get-all-equipments")
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        return ResponseEntity.ok(equipmentService.getAllEquipments());
    }

    @GetMapping("/get-by-id/{equipmentId}")
    public ResponseEntity<?> getEquipmentById(@PathVariable int equipmentId) {
        var resp = equipmentService.getEquipmentById(equipmentId);
        if(resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Equipment not found");
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/get-by-hospital-id/{hospitalId}")
    public ResponseEntity<List<Equipment>> getEquipmentByHospitalId(@PathVariable int hospitalId) {
        return ResponseEntity.ok(equipmentService.getEquipmentsByHospitalId(hospitalId));
    }

    @PutMapping("/update-equipment")
    public ResponseEntity<String> updateEquipment(@RequestBody EquipmentUpdateRequest request) {
        var resp = equipmentService.updateEquipment(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Equipment failed to update");
        return ResponseEntity.ok("Equipment updated successfully");
    }

    @DeleteMapping("/delete-by-id/{equipmentId}")
    public ResponseEntity<String> deleteEquipmentById(@PathVariable int equipmentId) {
        var resp = equipmentService.deleteEquipmentById(equipmentId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Equipment failed to delete");
        return ResponseEntity.ok("Equipment deleted successfully");
    }
}