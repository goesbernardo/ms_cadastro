package com.goesbernardo.microservico_cadastro.controller;

import com.goesbernardo.microservico_cadastro.dto.RestauranteDTO;
import com.goesbernardo.microservico_cadastro.entity.Restaurante;
import com.goesbernardo.microservico_cadastro.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/restaurante")
public class RestauranteController {


    private RestauranteService restauranteService;

    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity insertRestaurante(@RequestBody RestauranteDTO restauranteDTO){

        try {
            return ResponseEntity.ok(restauranteService.insertRestaurante(Restaurante.create(restauranteDTO)));
        } catch (Exception e) {
            ResponseEntity.badRequest().build();
        }
        return null;
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateRestaurante(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {

        Restaurante restaurantee = Restaurante.create(restauranteDTO);
        restaurantee.setId(id);

        Restaurante updateRestaurante =  restauranteService.updateRestaurante(restaurantee);

        if(updateRestaurante != null){
            return ResponseEntity.ok(updateRestaurante);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteRestaurantre(@PathVariable Long id) {

        return restauranteService.deleteRestaurante(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        Optional<Restaurante> restaurante = restauranteService.findById(id);

        return restaurante.isPresent() ? ResponseEntity.ok(restaurante.get()) : ResponseEntity.notFound().build();
    }

}
