package org.example.hospitalmanagementapi.controller;

import org.example.hospitalmanagementapi.Service.SaleService;
import org.example.hospitalmanagementapi.model.entity.Sale;
import org.example.hospitalmanagementapi.model.request.SaleCreateRequest;
import org.example.hospitalmanagementapi.model.request.SaleUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create-sale")
    public ResponseEntity<String> createSale(
            @RequestBody SaleCreateRequest request
    ) {
        var resp = saleService.createSale(request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sale creation failed");
        return ResponseEntity.ok("Sale created successfully");
    }

    @GetMapping("/get-by-prescription/{prescriptionId}")
    public ResponseEntity<List<Sale>> getSalesByPrescriptionId(
            @PathVariable int prescriptionId
    ) {
        return ResponseEntity.ok(saleService.getSalesByPrescriptionId(prescriptionId));
    }

    @GetMapping("/get-by-id/{salesId}")
    public ResponseEntity<?> getSaleById(
            @PathVariable int salesId
    ) {
        var resp = saleService.getSaleById(salesId);
        if (resp == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sale not found");
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/update-sale/{salesId}")
    public ResponseEntity<String> updateSale(
            @PathVariable int salesId,
            @RequestBody SaleUpdateRequest request
    ) {
        var resp = saleService.updateSale(salesId, request);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sale update failed");
        return ResponseEntity.ok("Sale updated successfully");
    }

    @DeleteMapping("/delete-by-id/{salesId}")
    public ResponseEntity<String> deleteSaleById(
            @PathVariable int salesId
    ) {
        var resp = saleService.deleteSaleById(salesId);
        if (resp < 1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sale deletion failed");
        return ResponseEntity.ok("Sale deleted successfully");
    }
}
