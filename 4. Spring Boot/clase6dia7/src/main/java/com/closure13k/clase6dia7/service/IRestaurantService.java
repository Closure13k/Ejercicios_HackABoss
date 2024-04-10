package com.closure13k.clase6dia7.service;

import com.closure13k.clase6dia7.dto.DishDTO;

public interface IRestaurantService {
    DishDTO fetchDishFullInfo(String dishName);
    
    DishDTO fetchDishWithCalories(String name);
    
    DishDTO fetchDishWithIngredients(String name);
    
    DishDTO fetchDishWithMostCaloricIngredient(String name);
}
