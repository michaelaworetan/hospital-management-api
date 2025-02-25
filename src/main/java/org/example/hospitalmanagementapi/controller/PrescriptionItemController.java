package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.PrescriptionItemService;
import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemCreateRequest;
import org.example.hospitalmanagementapi.model.request.PrescriptionItemUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription-items")
public class PrescriptionItemController {

    private final PrescriptionItemService prescriptionItemService;

    public PrescriptionItemController(PrescriptionItemService prescriptionItemService) {
        this.prescriptionItemService = prescriptionItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PrescriptionItem>> getAllPrescriptionItems() {
        List<PrescriptionItem> items = prescriptionItemService.getAllPrescriptionItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{prescriptionItemId}")
    public ResponseEntity<PrescriptionItem> getPrescriptionItemById(@PathVariable("prescriptionItemId") int id) {
        PrescriptionItem item = prescriptionItemService.getPrescriptionItemById(id);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPrescriptionItem(@RequestBody PrescriptionItemCreateRequest request) {
        int result = prescriptionItemService.createPrescriptionItem(request);
        if (result > 0) {
            return new ResponseEntity<>("Prescription item created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create prescription item", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePrescriptionItem(@RequestBody PrescriptionItemUpdateRequest request) {
        int result = prescriptionItemService.updatePrescriptionItem(request);
        if (result > 0) {
            return new ResponseEntity<>("Prescription item updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update prescription item", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{prescriptionItemId}")
    public ResponseEntity<String> deletePrescriptionItem(@PathVariable("prescriptionItemId") int id) {
        int result = prescriptionItemService.deletePrescriptionItemById(id);
        if (result > 0) {
            return new ResponseEntity<>("Prescription item deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete prescription item", HttpStatus.BAD_REQUEST);
        }
    }
}
