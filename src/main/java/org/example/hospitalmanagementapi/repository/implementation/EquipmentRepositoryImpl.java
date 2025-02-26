package org.example.hospitalmanagementapi.repository.implementation;

        import org.example.hospitalmanagementapi.mapper.EquipmentRowMapper;
        import org.example.hospitalmanagementapi.model.entity.Equipment;
        import org.example.hospitalmanagementapi.repository.Interface.EquipmentRepository;
        import org.example.hospitalmanagementapi.repository.query.EquipmentQuery;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
        import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
        import org.springframework.stereotype.Repository;

        import java.util.List;

        @Repository
        public class EquipmentRepositoryImpl implements EquipmentRepository {

            private final NamedParameterJdbcTemplate jdbcTemplate;

            @Autowired
            public EquipmentRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
            }

            @Override
            public List<Equipment> getAllEquipments() {
                return jdbcTemplate.query(EquipmentQuery.GET_ALL_EQUIPMENTS, new EquipmentRowMapper());
            }

            @Override
            public Equipment getEquipmentById(int equipmentId) {
                MapSqlParameterSource params = new MapSqlParameterSource("equipmentId", equipmentId);
                return jdbcTemplate.queryForObject(EquipmentQuery.GET_EQUIPMENT_BY_ID, params, new EquipmentRowMapper());
            }

            @Override
            public List<Equipment> getEquipmentsByHospitalId(int hospitalId) {
                MapSqlParameterSource params = new MapSqlParameterSource("equipmentHospitalId", hospitalId);
                return jdbcTemplate.query(EquipmentQuery.GET_EQUIPMENTS_BY_HOSPITAL_ID, params, new EquipmentRowMapper());
            }

            @Override
            public int createEquipment(Equipment equipment) {
                MapSqlParameterSource params = new MapSqlParameterSource()
                        .addValue("equipmentHospitalId", equipment.getEquipmentHospitalId())
                        .addValue("equipmentName", equipment.getEquipmentName())
                        .addValue("equipmentDescription", equipment.getEquipmentDescription())
                        .addValue("equipmentQuantity", equipment.getEquipmentQuantity());
                return jdbcTemplate.update(EquipmentQuery.INSERT_EQUIPMENT, params);
            }

            @Override
            public int updateEquipment(Equipment equipment) {
                MapSqlParameterSource params = new MapSqlParameterSource()
                        .addValue("equipmentId", equipment.getEquipmentId())
                        .addValue("equipmentHospitalId", equipment.getEquipmentHospitalId())
                        .addValue("equipmentName", equipment.getEquipmentName())
                        .addValue("equipmentDescription", equipment.getEquipmentDescription())
                        .addValue("equipmentQuantity", equipment.getEquipmentQuantity())
                        .addValue("equipmentStatus", equipment.getEquipmentStatus());
                return jdbcTemplate.update(EquipmentQuery.UPDATE_EQUIPMENT, params);
            }

            @Override
            public int deleteEquipmentById(int equipmentId) {
                MapSqlParameterSource params = new MapSqlParameterSource("equipmentId", equipmentId);
                return jdbcTemplate.update(EquipmentQuery.DELETE_EQUIPMENT_BY_ID, params);
            }
        }