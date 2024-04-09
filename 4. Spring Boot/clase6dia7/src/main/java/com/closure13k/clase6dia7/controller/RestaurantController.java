package com.closure13k.clase6dia7.controller;


import com.closure13k.clase6dia7.dto.DishDTO;
import com.closure13k.clase6dia7.service.IRestaurantService;
import com.closure13k.clase6dia7.service.RestaurantService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    
    private final IRestaurantService restaurantService;
    
    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
    @GetMapping("/dish")
    public ResponseEntity<DishDTO> getDishInfo(@RequestBody ObjectNode name) {
        
        try {
            return ResponseEntity.ok(restaurantService.getDishInfo(name.get("name").asText()));
        } catch (RestaurantService.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
    
/*
    Un restaurante necesita una API que proporcione información detallada sobre las calorías de los platos de su menú.
    
    Para esto, almacena en una base de datos lógica los siguientes datos:
        ?Platos: codigo_plato, nombre, precio, lista_Ingredientes
        ?Ingredientes: codigo_ingrediente, nombre, cantidad_calorias
    La API debe recibir el nombre de un plato como parámetro y devolver en base a esto:
        !1 - La cantidad total de calorías del plato completo.
        !2 - Una lista de ingredientes que componen el plato, junto con la cantidad de calorías de cada uno
        !    (la sumatoria de estas calorías deberían de dar la cantidad total de calorías del plato).
        !3 - El ingrediente con la mayor cantidad de calorías en el plato.
        ?       !!!   Utilizar para las responses el patrón DTO !!!
        
        !    Como ayuda, el dueño del restaurante nos brindó dos archivos .json con datos tanto de los
        !    platos con los que cuenta en el menú, como la lista completa de ingredientes con los que
        !    trabaja para cada plato.
    
    Utilizar ambos archivos como base de datos lógica del sistema.
    Cargar los datos del json a la aplicación y almacenar los datos en collections.
 */