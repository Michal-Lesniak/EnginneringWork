package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role, Long>{
    public RoleService(JpaRepository<Role, Long> repository) {
        super(repository);
    }
}
