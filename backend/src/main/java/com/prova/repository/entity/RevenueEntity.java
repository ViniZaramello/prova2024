package com.prova.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity(name = "revenue")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RevenueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    LocalTime preparationTime;

    @Column
    Float approximateCost;

}
