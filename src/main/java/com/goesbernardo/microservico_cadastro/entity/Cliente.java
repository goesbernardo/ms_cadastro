package com.goesbernardo.microservico_cadastro.entity;

import com.goesbernardo.microservico_cadastro.dto.ClienteDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public static Cliente create(ClienteDTO clienteDTO) {

        return new ModelMapper().map(clienteDTO, Cliente.class);
    }
}
