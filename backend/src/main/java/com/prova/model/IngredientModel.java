package com.prova.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientModel {
    Long id;
    String name;
    Long idRevenue;
    Float approximateCost;
}
