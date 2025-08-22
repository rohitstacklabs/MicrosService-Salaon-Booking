package com.rohit.service.impl;

import com.rohit.dto.SalonDto;
import com.rohit.dto.UserDto;
import com.rohit.model.Salon;
import com.rohit.repository.SalonRepository;
import com.rohit.service.SalonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }



    @Override
    public Salon createSalon(SalonDto salonDto, UserDto user) {
        Salon salon1 = new Salon();
        salon1.setName(salonDto.getName());  // ✅ No more error
        salon1.setAddress(salonDto.getAddress());
        salon1.setEmail(salonDto.getEmail());
        salon1.setCity(salonDto.getCity());
        salon1.setImages(salonDto.getImages());
        salon1.setOwnerId(user.getId());
        salon1.setOpenTime(salonDto.getOpenTime());
        salon1.setCloseTime(salonDto.getCloseTime());
        salon1.setPhoneNumber(salonDto.getPhoneNumber());

        return salonRepository.save(salon1);
    }


    @Override
    public Salon updateSalon(SalonDto salon, UserDto user, Long salonId) throws Exception {
        Salon existingSalon = salonRepository.findById(salonId).orElse(null);

        if(!salon.getOwnerId().equals(user.getId()))
        {
            throw new Exception("You don`t have permission to update this salon");
        }

        if(existingSalon != null)
        {
            existingSalon.setCity(salon.getCity());
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            existingSalon.setOwnerId(user.getId());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());
            return salonRepository.save(existingSalon);
        }
        throw new Exception("salon not exit");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();  // ✅ Fetch all salons from DB
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if(salon==null)
        {
            throw new Exception("salon not exit");
        }
        return salon;
    }

    @Override
    public Salon getSalonByOwerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);


    }

    @Override
    public List<Salon> searchSalonByCity(String city) {

        return salonRepository.searchSalons(city);
    }
}