package com.closure13k.clase6dia7.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Value
@Builder(setterPrefix = "with")
@JsonInclude(NON_NULL) // No incluir valores nulos en la respuesta.
public class IngredientDTO {
    String name;
    Double calories;
    Double totalCalories;
}
