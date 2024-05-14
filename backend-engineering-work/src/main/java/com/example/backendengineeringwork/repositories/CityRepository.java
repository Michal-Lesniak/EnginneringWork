package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.City;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM City c WHERE c.id = :id")
    Optional<City> findByIdWithLock(long id);
}
