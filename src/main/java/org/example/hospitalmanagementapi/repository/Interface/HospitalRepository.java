package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Hospital;

public interface HospitalRepository {

    Hospital getHospitalById(int hospitalId);

    int createHospital(Hospital hospital);

    int updateHospital(Hospital hospital);

    int deleteHospitalById(int hospitalId);
}
