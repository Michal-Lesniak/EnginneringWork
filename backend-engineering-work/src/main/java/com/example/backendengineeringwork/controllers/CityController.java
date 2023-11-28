package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.City;
import com.example.backendengineeringwork.services.CityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/cities")
public class CityController extends AbstractController<City, Long>{

    public CityController(CityService service) {
        super(service);
    }
}
