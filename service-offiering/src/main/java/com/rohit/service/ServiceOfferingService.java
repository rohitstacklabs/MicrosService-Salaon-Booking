package com.rohit.service;

import com.rohit.dto.CategoryDto;
import com.rohit.dto.SalonDto;
import com.rohit.dto.ServiceDto;
import com.rohit.model.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDto salonDto, ServiceDto serviceDto, CategoryDto categoryDto);

    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySalonId(Long salonId , Long categoryId);

    Set<ServiceOffering> getServiceByIds(Set<Long> ids);

    ServiceOffering getServiceById(Long id) throws Exception;

}
