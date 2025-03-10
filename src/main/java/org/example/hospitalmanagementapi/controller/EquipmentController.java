package org.example.hospitalmanagementapi.controller;

    import org.example.hospitalmanagementapi.Service.EquipmentService;
    import org.example.hospitalmanagementapi.model.request.EquipmentCreateRequest;
    import org.example.hospitalmanagementapi.model.request.EquipmentUpdateRequest;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.EquipmentListResponse;
    import org.example.hospitalmanagementapi.model.response.serviceresponse.EquipmentSingleResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/equipment")
    public class EquipmentController {
        private final EquipmentService equipmentService;

        @Autowired
        public EquipmentController(EquipmentService equipmentService) {
            this.equipmentService = equipmentService;
        }

        @PostMapping("/create-equipment")
        public BaseResponse createEquipment(@RequestBody EquipmentCreateRequest request) {
            return equipmentService.createEquipment(request);
        }

        @GetMapping("/get-all-equipments")
        public EquipmentListResponse getAllEquipments() {
            return equipmentService.getAllEquipments();
        }

        @GetMapping("/get-by-id/{equipmentId}")
        public EquipmentSingleResponse getEquipmentById(@PathVariable int equipmentId) {
            return equipmentService.getEquipmentById(equipmentId);
        }

        @GetMapping("/get-by-hospital-id/{hospitalId}")
        public EquipmentListResponse getEquipmentByHospitalId(@PathVariable int hospitalId) {
            return equipmentService.getEquipmentsByHospitalId(hospitalId);
        }

        @PutMapping("/update-equipment")
        public BaseResponse updateEquipment(@RequestBody EquipmentUpdateRequest request) {
            return equipmentService.updateEquipment(request);
        }

        @DeleteMapping("/delete-by-id/{equipmentId}")
        public BaseResponse deleteEquipmentById(@PathVariable int equipmentId) {
            return equipmentService.deleteEquipmentById(equipmentId);
        }
    }