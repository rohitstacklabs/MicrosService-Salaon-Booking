package com.rohit.service;

import com.rohit.dto.SalonDto;
import com.rohit.dto.UserDto;
import com.rohit.model.Salon;

import java.util.List;

public interface SalonService {

    Salon createSalon(SalonDto salon, UserDto user);

    Salon updateSalon(SalonDto salon, UserDto user , Long salonId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);

}
