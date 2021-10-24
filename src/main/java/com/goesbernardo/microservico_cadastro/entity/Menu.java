package com.goesbernardo.microservico_cadastro.entity;

import com.goesbernardo.microservico_cadastro.dto.MenuDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_MENU")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String preco;

    @ManyToOne
    private Restaurante restaurante;


    public static Menu create(MenuDTO menuDTO) {

        return new ModelMapper().map(menuDTO, Menu.class);
    }
}
