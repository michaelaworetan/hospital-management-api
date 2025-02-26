package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.SaleRowMapper;
import org.example.hospitalmanagementapi.model.entity.Sale;
import org.example.hospitalmanagementapi.repository.Interface.SaleRepository;
import org.example.hospitalmanagementapi.repository.query.SaleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SaleRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sale> getAllSales() {
        return jdbcTemplate.query(SaleQuery.GET_ALL_SALES, new SaleRowMapper());
    }

    @Override
    public Sale getSaleById(int salesId) {
        MapSqlParameterSource params = new MapSqlParameterSource("salesId", salesId);
        return jdbcTemplate.queryForObject(SaleQuery.GET_SALE_BY_ID, params, new SaleRowMapper());
    }

    @Override
    public int createSale(Sale sale) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("saleHospitalId", sale.getSaleHospitalId())
                .addValue("salesPrescriptionId", sale.getSalesPrescriptionId())
                .addValue("salesQuantity", sale.getSalesQuantity())
                .addValue("salesTotalPrice", sale.getSalesTotalPrice());
        return jdbcTemplate.update(SaleQuery.INSERT_SALE, params);
    }

    @Override
    public int updateSale(Sale sale) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("salesId", sale.getSalesId())
                .addValue("saleHospitalId", sale.getSaleHospitalId())
                .addValue("salesPrescriptionId", sale.getSalesPrescriptionId())
                .addValue("salesQuantity", sale.getSalesQuantity())
                .addValue("salesTotalPrice", sale.getSalesTotalPrice())
                .addValue("salesStatus", sale.getSalesStatus());
        return jdbcTemplate.update(SaleQuery.UPDATE_SALE, params);
    }

    @Override
    public int deleteSaleById(int salesId) {
        MapSqlParameterSource params = new MapSqlParameterSource("salesId", salesId);
        return jdbcTemplate.update(SaleQuery.DELETE_SALE_BY_ID, params);
    }
}
