package com.example.backendengineeringwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Możesz dodać tu metody, aby znaleźć rolę na podstawie nazwy, itp.
}