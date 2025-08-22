package com.rohit.controller;

import com.rohit.dto.CategoryDto;
import com.rohit.dto.SalonDto;
import com.rohit.dto.ServiceDto;
import com.rohit.model.ServiceOffering;

import com.rohit.service.ServiceOfferingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    public SalonServiceOfferingController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDto serviceDto)
    {
       SalonDto salonDto = new SalonDto();
       salonDto.setId(1L);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(serviceDto.getCategoryId());

        ServiceOffering serviceOffering = serviceOfferingService.createService(salonDto , serviceDto , categoryDto);
        return ResponseEntity.ok(serviceOffering);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
    ) throws Exception {
        ServiceOffering serviceOffering1 = serviceOfferingService.updateService(id , serviceOffering);
        return ResponseEntity.ok(serviceOffering1);

    }


}
