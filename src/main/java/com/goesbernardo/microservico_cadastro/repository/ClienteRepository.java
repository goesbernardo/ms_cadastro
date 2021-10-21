package com.goesbernardo.microservico_cadastro.repository;

import com.goesbernardo.microservico_cadastro.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}