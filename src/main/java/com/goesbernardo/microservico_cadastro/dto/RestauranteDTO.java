package com.goesbernardo.microservico_cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDTO {

    private String name;
    private String email;
    private String password;
}
