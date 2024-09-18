package com.prova.service;

import com.prova.model.IngredientModel;
import com.prova.model.RevenueModel;
import com.prova.repository.IngredientRepository;
import com.prova.repository.RevenueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public void createRevenue(RevenueModel revenue) {
        RevenueModel  idRevenue = revenueRepository.saveAndFlush(revenue);
        List<IngredientModel> ingredients = revenue.getIngredients();
        for (IngredientModel ingredient : ingredients) {
            ingredient.setRevenue(idRevenue);
            ingredientRepository.save(ingredient);
        }
    }

    public List<RevenueModel> getAllRevenues() {
        return revenueRepository.findAll();
    }

    public void updateRevenue(RevenueModel model, Long id) {
        if (!revenueRepository.existsById(id))
            throw new RuntimeException("Revenue not found");
        revenueRepository.save(model);
    }

    public void deleteRevenue(Long id) {
        if (!revenueRepository.existsById(id))
            throw new RuntimeException("Revenue not found");
        revenueRepository.deleteById(id);
    }
}
