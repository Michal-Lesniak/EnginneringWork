package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.CarModel;
import com.example.backendengineeringwork.repositories.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarModelService extends AbstractService<CarModel, Long>{

    public CarModelService(CarModelRepository repository){
        super(repository);
    }
}
