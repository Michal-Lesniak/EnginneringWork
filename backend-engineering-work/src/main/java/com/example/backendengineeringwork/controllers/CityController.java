package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController extends AbstractController<City, Long>{
}
