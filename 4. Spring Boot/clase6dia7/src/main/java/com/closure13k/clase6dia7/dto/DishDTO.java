package com.closure13k.clase6dia7.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Value
@Builder(setterPrefix = "with") //Pongo en práctica el patrón Builder.
@JsonInclude(NON_NULL) // No incluir valores nulos en la respuesta.
public class DishDTO {
    String name;
    Double price;
    Double calories;
    IngredientDTO mostCaloricIngredient;
    List<IngredientDTO> ingredients;
}
