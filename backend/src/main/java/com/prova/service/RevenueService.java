package com.prova.service;

import com.prova.controller.dto.RevenueDto;
import com.prova.model.RevenueModel;
import com.prova.repository.IngredientRepository;
import com.prova.repository.RevenueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RevenueService {

    @Autowired
    private IngredientRepository ingredientRepository;
    private RevenueRepository revenueRepository;

    public void createRevenue(RevenueDto revenueDto) {
        revenueRepository.save(revenueDto);
    }

    public ResponseEntity<RevenueModel> getRevenue() {
        return revenueRepository.findAll();
    }
}
