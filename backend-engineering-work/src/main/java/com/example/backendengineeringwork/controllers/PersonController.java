package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.Person;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController extends AbstractController<Person, Long> {
}