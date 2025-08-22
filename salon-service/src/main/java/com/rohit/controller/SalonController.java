package com.rohit.controller;

import com.rohit.dto.SalonDto;
import com.rohit.dto.UserDto;
import com.rohit.mapper.SalonMapper;
import com.rohit.model.Salon;
import com.rohit.service.SalonService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
public class SalonController {


    private final SalonService salonService;


    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    // - http://localhost:5002/api/salons

    @PostMapping
    public ResponseEntity<SalonDto> createSalon(@RequestBody SalonDto salonDto)
    {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        Salon salon = salonService.createSalon(salonDto , userDto);
        SalonDto salonDto1 = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDto1);
    }

    @PatchMapping("/{salonId}")
    public ResponseEntity<SalonDto> updateSalon(
            @PathVariable Long salonId,
            @RequestBody SalonDto salonDto) throws Exception
    {
        UserDto userDTO = new UserDto();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonDto, userDTO,salonId);
        SalonDto salonDto1 = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDto1);
    }

    // - http://localhost:5002/api/salons
    @GetMapping()
    public ResponseEntity<List<SalonDto>> getSalons() throws Exception
    {

        List<Salon> salons = salonService.getAllSalons();

        List<SalonDto> salonDtos = salons.stream().map((salon) -> {
            SalonDto salonDto = SalonMapper.mapToDTO(salon);
            return salonDto;
        }).toList();

        return ResponseEntity.ok(salonDtos);

    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDto> getSalonById(@PathVariable Long salonId) throws Exception {

        Salon salon = salonService.getSalonById(salonId);
        SalonDto salonDto = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDto);
    }

    // http://localhost:5002/api/salons/search?city=mumbai
    @GetMapping("/search")
    public ResponseEntity<List<SalonDto>> searchSalons(@RequestParam("city") String city) throws Exception
    {

        List<Salon> salons = salonService.searchSalonByCity(city);

        List<SalonDto> salonDtos = salons.stream().map((salon) -> {
            SalonDto salonDto = SalonMapper.mapToDTO(salon);
            return salonDto;
        }).toList();

        return ResponseEntity.ok(salonDtos);

    }

    // http://localhost:5002/api/salons/5
    @GetMapping("/owner")
    public ResponseEntity<SalonDto> getSalonByOwerId(@PathVariable Long salonId) throws Exception
    {
        UserDto userDTO = new UserDto();
        userDTO.setId(1L);

        Salon salon = salonService.getSalonByOwerId(userDTO.getId());
        SalonDto salonDto = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDto);
    }

}
