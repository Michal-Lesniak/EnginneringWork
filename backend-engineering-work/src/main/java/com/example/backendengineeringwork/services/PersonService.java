package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<Person, Long> {
    public PersonService(JpaRepository<Person, Long> repository) {
        super(repository);
    }
    // Możesz dodać dodatkowe metody specyficzne dla Person jeśli potrzebujesz
}
