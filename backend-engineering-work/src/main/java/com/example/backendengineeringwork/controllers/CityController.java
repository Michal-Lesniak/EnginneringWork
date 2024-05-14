package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.commands.city.CityCreateCommand;
import com.example.backendengineeringwork.dtos.city.CityDto;
import com.example.backendengineeringwork.models.City;
import com.example.backendengineeringwork.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CityController{

    private final CityService cityService;

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable long id) {
        return cityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto create(@RequestBody CityCreateCommand command){
        return cityService.save(command);
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable long id, @RequestBody CityCreateCommand command){
        return cityService.update(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        cityService.deleteById(id);
    }
}
