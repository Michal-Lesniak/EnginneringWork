package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.models.AppUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractController<AppUser, Long>{
}
