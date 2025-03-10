package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Sale;
import org.example.hospitalmanagementapi.model.request.SaleCreateRequest;
import org.example.hospitalmanagementapi.model.request.SaleUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.SaleListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.SaleSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionItemRepository;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionRepository;
import org.example.hospitalmanagementapi.repository.Interface.SaleRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    private final PrescriptionRepository prescriptionRepository;

    private final MedicationRepository medicationRepository;

    private final PrescriptionItemRepository prescriptionItemRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository,
                       PrescriptionRepository prescriptionRepository,
                       MedicationRepository medicationRepository,
                       PrescriptionItemRepository prescriptionItemRepository)
    {
        this.saleRepository = saleRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicationRepository = medicationRepository;
        this.prescriptionItemRepository = prescriptionItemRepository;
    }

    public SaleListResponse getAllSales() {
        var sales = saleRepository.getAllSales();
        return SaleListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .sales(sales)
                .build();
    }

    public SaleSingleResponse getSaleById(int salesId) {
        var sale = saleRepository.getSaleById(salesId);
        return SaleSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .sale(sale)
                .build();
    }

    public SaleListResponse getSalesByHospitalId(int saleHospitalId) {
        var sales = saleRepository.getSalesByHospitalId(saleHospitalId);

        return SaleListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .sales(sales)
                .build();
    }

    public BaseResponse createSale(SaleCreateRequest request) {
        Gson gson = new Gson();
        var prescription = prescriptionRepository.getPrescriptionById(request.getSalesPrescriptionId());
        if (prescription == null) {
            return new BaseResponse("106", "Prescription not found");
        }
        var prescriptionItem = prescriptionItemRepository.getPrescriptionItemsByPrescriptionId(prescription.getPrescriptionId());
        for(var item : prescriptionItem){
            var medication = medicationRepository.getMedicationById(item.getPrescriptionItemMedicationId());
            if(medication == null){
                return new BaseResponse("106", "Medication not found");
            }
            var remainingStock = medication.getMedicationStockQuantity() - item.getPrescriptionItemQuantity();
            if(remainingStock < 0){
                return new BaseResponse("106", "Stock not enough");
            }
            medication.setMedicationStockQuantity(remainingStock);
            medicationRepository.updateMedication(medication);
        }
        var sale = gson.fromJson(gson.toJson(request), Sale.class);
        saleRepository.createSale(sale);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateSale(SaleUpdateRequest request) {
        Gson gson = new Gson();
        var prescription = prescriptionRepository.getPrescriptionById(request.getSalesPrescriptionId());
        if (prescription == null) {
            return new BaseResponse("106", "Prescription not found");
        }
        var sale = gson.fromJson(gson.toJson(request), Sale.class);
        saleRepository.updateSale(sale);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteSaleById(int salesId) {
        saleRepository.deleteSaleById(salesId);
        return ResponseConstants.SUCCESS;
    }
}
