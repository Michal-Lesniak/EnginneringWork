package com.example.backendengineeringwork.models;

import com.example.backendengineeringwork.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @NotNull
    private LocalDateTime rentDate;

    @NotNull
    private LocalDateTime arrivalDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rentCity_id")
    private City rentCity;

    @ManyToOne
    @JoinColumn(name = "arrivalCity_id")
    private City arrivalCity;
}
