package com.prova.mapper;

import com.prova.controller.dto.RevenueDto;
import com.prova.model.RevenueModel;
import com.prova.repository.entity.RevenueEntity;

public class RevenueMappper {

    public RevenueModel toModel(RevenueDto revenueDto) {
        return RevenueModel.builder()
                .name(revenueDto.name())
                .preparationTime(revenueDto.preparationTime())
                .approximateCost(revenueDto.approximateCost())
                .ingredients(revenueDto.ingredients())
                .build();
    }

    public RevenueEntity toEntity(RevenueModel revenueModel) {
        return RevenueEntity.builder()
                .name(revenueModel.name())
                .preparationTime(revenueModel.preparationTime())
                .approximateCost(revenueModel.approximateCost())
                .ingredients(revenueModel.ingredients())
                .build();
    }

}
