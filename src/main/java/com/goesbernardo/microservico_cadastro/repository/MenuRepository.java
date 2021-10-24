package com.goesbernardo.microservico_cadastro.repository;

import com.goesbernardo.microservico_cadastro.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {

}