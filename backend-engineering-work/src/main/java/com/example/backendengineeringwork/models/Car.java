package com.example.backendengineeringwork.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotNull
    private Integer rentPrizePerDay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private CarModel model;

    @NotNull
    @PastOrPresent
    private Integer productionYear;
}
