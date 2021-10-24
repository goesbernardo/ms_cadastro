package com.goesbernardo.microservico_cadastro.service;

import com.goesbernardo.microservico_cadastro.dto.MenuDTO;
import com.goesbernardo.microservico_cadastro.entity.Cliente;
import com.goesbernardo.microservico_cadastro.entity.Menu;
import com.goesbernardo.microservico_cadastro.entity.Restaurante;
import com.goesbernardo.microservico_cadastro.repository.ClienteRepository;
import com.goesbernardo.microservico_cadastro.repository.MenuRepository;
import com.goesbernardo.microservico_cadastro.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {


    private MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    @Autowired
    private RestauranteRepository restauranteRepository;



    public Menu insertMenu(MenuDTO menuDTO){

        Optional<Restaurante> restaurante = restauranteRepository.findById(menuDTO.getRestaurante());

        if(restaurante.isPresent()){
            Menu menu = Menu.create(menuDTO);
            menu.setRestaurante(restaurante.get());
            menuRepository.save(menu);
        } else {
            return null;
        }
        return null;
    }

    public Menu updateMenu(Menu menu) {

        Optional<Menu> newClient = menuRepository.findById(menu.getId());

        if(newClient.isPresent()){
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    public Boolean deleteMenu(Long id) {

        Optional<Menu> menu = menuRepository.findById(id);
        if(menu.isPresent()){
            menuRepository.delete(menu.get());
            return true;
        } else {
            return false;
        }

    }

    public Optional<Menu> findById(Long id) {

        return menuRepository.findById(id);
    }
}
