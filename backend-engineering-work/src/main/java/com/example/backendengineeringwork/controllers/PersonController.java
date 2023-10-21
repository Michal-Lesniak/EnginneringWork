package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController extends AbstractController<Person, Long> {
    // Jeśli potrzebujesz dodatkowych endpointów specyficznych dla Person, dodaj je tutaj.
}