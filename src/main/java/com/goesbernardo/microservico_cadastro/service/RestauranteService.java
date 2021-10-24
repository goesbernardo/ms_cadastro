package com.goesbernardo.microservico_cadastro.service;

import com.goesbernardo.microservico_cadastro.entity.Restaurante;
import com.goesbernardo.microservico_cadastro.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {


   private RestauranteRepository restauranteRepository;

   @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante insertRestaurante(Restaurante restaurante){

        return  restauranteRepository.save(restaurante);
    }

    public Restaurante updateRestaurante(Restaurante restaurante) {

        Optional<Restaurante> newRestaurante = restauranteRepository.findById(restaurante.getId());

        if(newRestaurante.isPresent()){
            return restauranteRepository.save(restaurante);
        } else {
            return null;
        }
    }

    public Boolean deleteRestaurante(Long id) {

        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        if(restaurante.isPresent()){
            restauranteRepository.delete(restaurante.get());
            return true;
        } else {
            return false;
        }

    }

    public Optional<Restaurante> findById(Long id) {

        return restauranteRepository.findById(id);
    }
}
