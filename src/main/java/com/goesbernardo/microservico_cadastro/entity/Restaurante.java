package com.goesbernardo.microservico_cadastro.entity;

import com.goesbernardo.microservico_cadastro.dto.ClienteDTO;
import com.goesbernardo.microservico_cadastro.dto.RestauranteDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_RESTAURANTE")
@Data
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public static Restaurante create(RestauranteDTO restauranteDTO) {

        return new ModelMapper().map(restauranteDTO, Restaurante.class);
    }
}
