package com.prova.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

//@TODO adicionar mensagem de erro

public record RevenueDto(

        @NotBlank(message = "nome não pode ser vazio")
        String name,

        @NotNull(message = "tempo de preparação não pode ser nulo")
        LocalTime preparationTime,

        @NotNull(message = "Custo aproximado nõa pode ser nulo")
        Float approximateCost,

        List<IngredientDto> ingredients
) {
}