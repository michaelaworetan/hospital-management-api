package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Hospital;

import java.util.List;

public interface HospitalRepository {

    List<Hospital> getAllHospitals();

    Hospital getHospitalById(int hospitalId);

    int createHospital(Hospital hospital);

    int updateHospital(Hospital hospital);

    int deleteHospitalById(int hospitalId);

}
