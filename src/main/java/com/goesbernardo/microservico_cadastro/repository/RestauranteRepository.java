package com.goesbernardo.microservico_cadastro.repository;

import com.goesbernardo.microservico_cadastro.entity.Cliente;
import com.goesbernardo.microservico_cadastro.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {

}