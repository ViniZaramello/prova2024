package com.prova.mapper;

import com.prova.controller.dto.RevenueDto;
import com.prova.model.RevenueModel;
import java.util.stream.Collectors;

public class RevenueMapper {

    public static RevenueModel toModel(RevenueDto revenueDto) {
        return RevenueModel.builder()
                .name(revenueDto.name())
                .preparationTime(revenueDto.preparationTime())
                .approximateCost(revenueDto.approximateCost())
                .ingredients(revenueDto.ingredients().stream()
                        .map(IngredientMapper::toModel).collect(Collectors.toList()))
                .build();
    }
}
