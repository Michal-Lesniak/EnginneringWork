package com.example.backendengineeringwork.dummy;

import com.example.backendengineeringwork.controllers.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestEntity, Long> {}
