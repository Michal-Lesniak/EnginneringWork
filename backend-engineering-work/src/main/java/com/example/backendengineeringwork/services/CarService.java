package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.Car;
import com.example.backendengineeringwork.repositories.CarModelRepository;
import com.example.backendengineeringwork.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService extends AbstractService<Car, Long>{

    public CarService(CarRepository repository){
        super(repository);
    }
}
