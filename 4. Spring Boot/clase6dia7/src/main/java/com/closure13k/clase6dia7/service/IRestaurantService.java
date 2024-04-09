package com.closure13k.clase6dia7.service;

import com.closure13k.clase6dia7.dto.DishDTO;
import com.closure13k.clase6dia7.dto.IngredientDTO;

import java.util.List;

public interface IRestaurantService {
    DishDTO getDishInfo(String dishName);
}
