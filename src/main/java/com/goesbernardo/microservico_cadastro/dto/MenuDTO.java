package com.goesbernardo.microservico_cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

    private String name;
    private String preco;
    private Long restaurante;
}
