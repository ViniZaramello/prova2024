package com.prova.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

//@TODO adicionar mensagem de erro
@Builder
public record IngredientDto(

        @NotBlank
        String name,

        @NotNull
        Long idRevenue
) {
}