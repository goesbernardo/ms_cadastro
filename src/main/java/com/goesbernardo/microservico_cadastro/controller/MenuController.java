package com.goesbernardo.microservico_cadastro.controller;

import com.goesbernardo.microservico_cadastro.dto.MenuDTO;
import com.goesbernardo.microservico_cadastro.entity.Menu;
import com.goesbernardo.microservico_cadastro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/menu")
public class MenuController {


    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity insertMenu(@RequestBody MenuDTO menuDTO){

        try {
            Menu menu = menuService.insertMenu(menuDTO);
            return Objects.nonNull(menu) ? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e);
        }
        return null;
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateMenu(@PathVariable Long id, @RequestBody MenuDTO menuDTO) {

        Menu menu = Menu.create(menuDTO);
        menu.setId(id);

        Menu updateMenu =  menuService.updateMenu(menu);

        if(updateMenu != null){
            return ResponseEntity.ok(updateMenu);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteMenu(@PathVariable Long id) {

        return menuService.deleteMenu(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        Optional<Menu> menu = menuService.findById(id);

        return menu.isPresent() ? ResponseEntity.ok(menu.get()) : ResponseEntity.notFound().build();
    }

}
