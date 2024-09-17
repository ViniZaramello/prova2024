package com.prova.repository;


import com.prova.model.IngredientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientModel, Long>{

}
