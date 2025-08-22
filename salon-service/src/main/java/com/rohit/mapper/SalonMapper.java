package com.rohit.mapper;

import com.rohit.dto.SalonDto;
import com.rohit.model.Salon;

public class SalonMapper {

    public static SalonDto mapToDTO(Salon salon) {
        SalonDto salonDto = new SalonDto();
        salonDto.setId(salon.getId());
        salonDto.setName(salon.getName());
        salonDto.setAddress(salon.getAddress());
        salonDto.setEmail(salon.getEmail());
        salonDto.setCity(salon.getCity());
        salonDto.setImages(salon.getImages());
        salonDto.setOpenTime(salon.getOpenTime());
        salonDto.setCloseTime(salon.getCloseTime());
        salonDto.setOwnerId(salon.getOwnerId());
        salonDto.setPhoneNumber(salon.getPhoneNumber());
        return salonDto;
    }
}
