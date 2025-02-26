package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Sale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleRowMapper implements RowMapper<Sale> {
    @Override
    public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Sale.builder()
                .salesId(rs.getInt("salesId"))
                .salesPrescriptionId(rs.getInt("salesPrescriptionId"))
                .salesQuantity(rs.getInt("salesQuantity"))
                .salesTotalPrice(rs.getBigDecimal("salesTotalPrice"))
                .salesStatus(rs.getString("salesStatus"))
                .salesCreatedAt(rs.getString("salesCreatedAt"))
                .salesUpdatedAt(rs.getString("salesUpdatedAt"))
                .build();
    }
}
