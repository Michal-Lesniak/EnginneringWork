package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EngineService extends AbstractService<Engine, Long>{

    public EngineService(JpaRepository<Engine, Long> repository) {
        super(repository);
    }
}
