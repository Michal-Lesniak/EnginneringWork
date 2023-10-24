package com.example.backendengineeringwork.repositories;

import com.example.backendengineeringwork.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String username);
    // Możesz dodać tu metody, aby znaleźć użytkownika na podstawie loginu, itp.
}

