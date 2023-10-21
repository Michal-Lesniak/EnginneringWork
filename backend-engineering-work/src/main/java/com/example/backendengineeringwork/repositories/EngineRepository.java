package com.example.backendengineeringwork.repositories;


import com.example.backendengineeringwork.models.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
}