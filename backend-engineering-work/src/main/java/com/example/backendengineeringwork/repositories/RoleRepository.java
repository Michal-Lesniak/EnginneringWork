package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Możesz dodać tu metody, aby znaleźć rolę na podstawie nazwy, itp.
}