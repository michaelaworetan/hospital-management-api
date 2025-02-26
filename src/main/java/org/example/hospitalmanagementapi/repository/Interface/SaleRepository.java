package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Sale;

import java.util.List;

public interface SaleRepository {

    List<Sale> getAllSales();

    Sale getSaleById(int salesId);

    List<Sale> getSalesByHospitalId(int saleHospitalId);

    int createSale(Sale sale);

    int updateSale(Sale sale);

    int deleteSaleById(int salesId);
}
