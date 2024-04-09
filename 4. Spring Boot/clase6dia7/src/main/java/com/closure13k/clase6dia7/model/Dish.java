package com.closure13k.clase6dia7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private Integer id;
    private String name;
    private Double price;
    private List<Integer> ingredients;
}
