package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<AppUser, Long>{
    public UserService(JpaRepository<AppUser, Long> repository) {
        super(repository);
    }
}
