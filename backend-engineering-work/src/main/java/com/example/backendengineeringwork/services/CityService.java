package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.City;
import com.example.backendengineeringwork.repositories.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService extends AbstractService<City, Long>{

    public CityService(CityRepository repository){
        super(repository);
    }
}
