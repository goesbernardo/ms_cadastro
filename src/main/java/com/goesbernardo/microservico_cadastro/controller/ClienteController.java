package com.goesbernardo.microservico_cadastro.controller;

import com.goesbernardo.microservico_cadastro.dto.ClienteDTO;
import com.goesbernardo.microservico_cadastro.entity.Cliente;
import com.goesbernardo.microservico_cadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/cliente")
public class ClienteController {


    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity insertCliente(@RequestBody ClienteDTO clienteDTO){

        try {
            return ResponseEntity.ok(clienteService.insertClient(Cliente.create(clienteDTO)));
        } catch (Exception e) {
            ResponseEntity.badRequest().build();
        }
        return null;
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {

        Cliente cliente = Cliente.create(clienteDTO);
        cliente.setId(id);

        Cliente updateCliente =  clienteService.updateClient(cliente);

        if(updateCliente != null){
            return ResponseEntity.ok(updateCliente);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {

        return clienteService.deleteClient(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        Optional<Cliente> cliente = clienteService.findById(id);

        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
    }

}
