package com.prova.mapper;

import com.prova.controller.dto.IngredientDto;
import com.prova.model.IngredientModel;
import com.prova.model.RevenueModel;

public class IngredientMapper {

    public static IngredientModel toModel(IngredientDto ingredientDto) {
        return IngredientModel.builder()
                .name(ingredientDto.name())
                .revenue(RevenueModel.builder().id(ingredientDto.idRevenue()).build())
                .build();
    }
}