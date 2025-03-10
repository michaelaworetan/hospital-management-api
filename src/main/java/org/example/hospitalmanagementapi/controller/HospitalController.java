package org.example.hospitalmanagementapi.controller;

    import org.example.hospitalmanagementapi.Service.HospitalService;
    import org.example.hospitalmanagementapi.model.request.HospitalCreateRequest;
    import org.example.hospitalmanagementapi.model.request.HospitalUpdateRequest;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.HospitalListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.HospitalSingleResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/hospital")
    public class HospitalController {
        private final HospitalService hospitalService;

        @Autowired
        public HospitalController(HospitalService hospitalService) {
            this.hospitalService = hospitalService;
        }

        @PostMapping("/create-hospital")
        public BaseResponse createHospital(@RequestBody HospitalCreateRequest request) {
            return hospitalService.createHospital(request);
        }

        @GetMapping("/get-all-hospitals")
        public HospitalListResponse getAllHospitals() {
            return hospitalService.getAllHospitals();
        }

        @GetMapping("/get-by-id/{hospitalId}")
        public HospitalSingleResponse getHospitalById(@PathVariable int hospitalId) {
            return hospitalService.getHospitalById(hospitalId);
        }

        @PutMapping("/update-hospital")
        public BaseResponse updateHospital(@RequestBody HospitalUpdateRequest request) {
            return hospitalService.updateHospital(request);
        }

        @DeleteMapping("/delete-by-id/{hospitalId}")
        public BaseResponse deleteHospitalById(@PathVariable int hospitalId) {
            return hospitalService.deleteHospitalById(hospitalId);
        }
    }