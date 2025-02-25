package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Sale;

import java.util.List;

public interface SaleRepository {

    int createSale(Sale sale);

    Sale getSaleById(int salesId);

    List<Sale> getSalesByPrescriptionId(int salesPrescriptionId);

    int updateSale(Sale sale);

    int deleteSaleById(int salesId);
}
