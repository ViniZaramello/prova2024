package com.prova.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ingredient")
public class IngredientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_revenue")
    private RevenueModel revenue;

    @Column
    private Float approximateCost;

}
