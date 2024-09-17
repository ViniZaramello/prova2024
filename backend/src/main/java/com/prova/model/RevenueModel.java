package com.prova.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevenueModel {
    Long id;
    String name;
    IngredientModel ingredients;
    LocalTime preparationTime;
    Float approximateCost;
}
