package com.prova.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "revenue")
public class RevenueModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalTime preparationTime;

    @OneToMany(mappedBy = "revenue")
    private List<IngredientModel> ingredients;

    @Column
    private Float approximateCost;
}
