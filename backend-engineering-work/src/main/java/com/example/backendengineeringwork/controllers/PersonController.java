package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Person;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController extends AbstractController<Person, Long> {
    //TODO ewentualnie dodac Patch dla niektorych sytuacji np zmiana emailu
}