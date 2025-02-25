package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Sale;
import org.example.hospitalmanagementapi.model.request.SaleCreateRequest;
import org.example.hospitalmanagementapi.model.request.SaleUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
//    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
//        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Sale> getSalesByPrescriptionId(int salesPrescriptionId) {
        return saleRepository.getSalesByPrescriptionId(salesPrescriptionId);
    }

    public Sale getSaleById(int salesId) {
        return saleRepository.getSaleById(salesId);
    }

    public int createSale(SaleCreateRequest request) {
        Gson gson = new Gson();

        // Validate that the prescription exists before creating sale
//        var prescription = prescriptionRepository.getPrescriptionById(request.getSalesPrescriptionId());
//        if (prescription == null) {
//            return -1;
//        }

        var sale = gson.fromJson(gson.toJson(request), Sale.class);
        return saleRepository.createSale(sale);
    }

    public int updateSale(int salesId, SaleUpdateRequest request) {
        Gson gson = new Gson();

        // Validate that the prescription exists before updating sale
//        var prescription = prescriptionRepository.getPrescriptionById(request.getSalesPrescriptionId());
//        if (prescription == null) {
//            return -1;
//        }

        var sale = gson.fromJson(gson.toJson(request), Sale.class);
        sale.setSalesId(salesId);

        return saleRepository.updateSale(sale);
    }

    public int deleteSaleById(int salesId) {
        return saleRepository.deleteSaleById(salesId);
    }
}
