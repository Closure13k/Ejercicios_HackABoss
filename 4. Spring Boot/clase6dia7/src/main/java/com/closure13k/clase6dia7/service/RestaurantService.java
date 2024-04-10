package com.closure13k.clase6dia7.service;

import com.closure13k.clase6dia7.dto.DishDTO;
import com.closure13k.clase6dia7.dto.IngredientDTO;
import com.closure13k.clase6dia7.model.Dish;
import com.closure13k.clase6dia7.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;

@Service
public class RestaurantService implements IRestaurantService {
    private static final List<Ingredient> INGREDIENTS = new ArrayList<>();
    private static final List<Dish> DISHES = new ArrayList<>();
    
    /**
     * Obtiene un plato por su nombre.
     * Devuelve un DTO con toda la información del plato.
     *
     * @param dishName Nombre del plato.
     * @return DTO del plato.
     */
    @Override
    public DishDTO fetchDishFullInfo(String dishName) {
        Dish dish = getDishByName(dishName);
        List<Ingredient> ingredients = getIngredients(dish);
        Double totalCalories = calculateTotalCalories(ingredients);
        Ingredient mostCaloricIngredient = getMostCaloricIngredient(ingredients);
        List<IngredientDTO> ingredientDTOs = toDTOs(ingredients);
        
        return toDTO(dish, totalCalories, mostCaloricIngredient, ingredientDTOs);
    }
    
    /**
     * Obtiene un plato por su nombre y devuelve un DTO con el nombre y las calorías del plato.
     *
     * @param name Nombre del plato.
     * @return DTO con el nombre y las calorías del plato.
     */
    @Override
    public DishDTO fetchDishWithCalories(String name) {
        Dish dish = getDishByName(name);
        return DishDTO.builder()
                .withName(dish.getName())
                .withCalories(calculateTotalCaloriesForDish(dish))
                .build();
    }
    
    /**
     * Obtiene un plato por su nombre y devuelve un DTO con el nombre y los ingredientes del plato.
     *
     * @param name Nombre del plato.
     * @return DTO con el nombre y los ingredientes del plato.
     */
    
    @Override
    public DishDTO fetchDishWithIngredients(String name) {
        Dish dish = getDishByName(name);
        return DishDTO.builder()
                .withName(dish.getName())
                .withIngredients(toDTOs(getIngredients(dish)))
                .build();
    }
    
    /**
     * Obtiene un plato por su nombre y devuelve un DTO con el nombre y el ingrediente más calórico del plato.
     *
     * @param name Nombre del plato.
     * @return DTO con el nombre y el ingrediente más calórico del plato.
     */
    @Override
    public DishDTO fetchDishWithMostCaloricIngredient(String name) {
        Dish dish = getDishByName(name);
        return DishDTO.builder()
                .withName(dish.getName())
                .withMostCaloricIngredient(toDTO(getMostCaloricIngredient(getIngredients(dish))))
                .build();
    }
    
    
    /**
     * Obtiene un plato por su nombre.
     *
     * @param dishName Nombre del plato.
     * @return Plato.
     * @throws NotFoundException Si no se encuentra el plato.
     */
    private Dish getDishByName(String dishName) {
        return DISHES.stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(dishName + " no encontrado"));
    }
    
    /**
     * Obtiene los ingredientes de un plato.
     *
     * @param dish Plato.
     * @return Lista de ingredientes.
     */
    private List<Ingredient> getIngredients(Dish dish) {
        return dish.getIngredients().stream()
                .map(RestaurantService::mapToIngredient)
                .toList();
    }
    
    
    /**
     * Calcula la cantidad total de calorías de una lista de ingredientes.
     *
     * @param ingredients Lista de ingredientes.
     * @return Cantidad total de calorías.
     */
    private double calculateTotalCalories(List<Ingredient> ingredients) {
        return ingredients.stream()
                .mapToDouble(Ingredient::getCalories)
                .sum();
    }
    
    /**
     * Calcula la cantidad total de calorías de un plato.
     * Versión más eficiente que {@link #calculateTotalCalories(List)}.
     * Esto se debe a que en este caso no se necesita obtener los ingredientes.
     *
     * @param dish El plato.
     * @return Cantidad total de calorías.
     */
    private double calculateTotalCaloriesForDish(Dish dish) {
        return dish.getIngredients().stream()
                .mapToDouble(i -> mapToIngredient(i).getCalories())
                .sum();
    }
    
    /**
     * Mapea un id a su respectivo ingrediente.
     *
     * @param ingredientId Id del ingrediente.
     * @return Ingrediente.
     */
    private static Ingredient mapToIngredient(Integer ingredientId) {
        return INGREDIENTS.stream()
                .filter(ing -> ing.getId().equals(ingredientId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Ingrediente no encontrado: " + ingredientId));
    }
    
    
    /**
     * Obtiene el ingrediente más calórico de una lista de ingredientes.
     *
     * @param ingredients Lista de ingredientes.
     * @return Ingrediente más calórico.
     * @throws NotFoundException Si no se encuentra el ingrediente más calórico.
     */
    private Ingredient getMostCaloricIngredient(List<Ingredient> ingredients) {
        return ingredients.stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .orElseThrow(() -> new NotFoundException("No se encontró el ingrediente más calórico"));
    }
    
    // DTOs
    
    /**
     * Convierte un ingrediente a un DTO.
     *
     * @param dish                  Plato.
     * @param totalCalories         Cantidad total de calorías.
     * @param mostCaloricIngredient Ingrediente más calórico.
     * @param ingredientDTOs        Lista de ingredientes.
     * @return DTO.
     */
    private DishDTO toDTO(Dish dish, Double totalCalories, Ingredient mostCaloricIngredient, List<IngredientDTO> ingredientDTOs) {
        return DishDTO.builder()
                .withName(dish.getName())
                .withPrice(dish.getPrice())
                .withCalories(totalCalories)
                .withMostCaloricIngredient(toDTO(mostCaloricIngredient))
                .withIngredients(ingredientDTOs)
                .build();
    }
    
    
    /**
     * Convierte un ingrediente a un DTO.
     *
     * @param mostCaloricIngredient Ingrediente más calórico.
     * @return DTO.
     */
    private static IngredientDTO toDTO(Ingredient mostCaloricIngredient) {
        return IngredientDTO.builder()
                .withName(mostCaloricIngredient.getName())
                .withCalories(mostCaloricIngredient.getCalories())
                .build();
    }
    
    /**
     * Convierte una lista de ingredientes a una lista de DTOs.
     *
     * @param ingredients Lista de ingredientes.
     * @return Lista de DTOs.
     */
    private List<IngredientDTO> toDTOs(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(RestaurantService::toDTO)
                .toList();
    }
    
    
    //<editor-fold desc="Generated code" defaultstate="collapsed">
    public RestaurantService() {
        loadDatabase();
    }
    
    private void loadDatabase() {
        File ingredientsFile;
        File dishesFile;
        try {
            ingredientsFile = ResourceUtils.getFile("classpath:jsondata/ingredients.json");
            dishesFile = ResourceUtils.getFile("classpath:jsondata/dishes.json");
        } catch (FileNotFoundException e) {
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredient>> ingredientTypeRef = new TypeReference<>() {
        };
        TypeReference<List<Dish>> dishTypeRef = new TypeReference<>() {
        };
        try {
            INGREDIENTS.addAll(mapper.readValue(ingredientsFile, ingredientTypeRef));
            DISHES.addAll(mapper.readValue(dishesFile, dishTypeRef));
        } catch (Exception ignored) {
            // Ignored
        }
    }
    //</editor-fold>
    
    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}
