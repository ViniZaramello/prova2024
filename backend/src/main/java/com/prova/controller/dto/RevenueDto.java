package com.prova.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

//@TODO adicionar mensagem de erro

public record RevenueDto(

        @NotBlank
        String name,

        @NotNull
        LocalTime preparationTime,

        @NotNull
        Float approximateCost,

        @NotBlank
        List<IngredientDto> ingredients
) {
}