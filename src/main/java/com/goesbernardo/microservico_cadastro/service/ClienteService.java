package com.goesbernardo.microservico_cadastro.service;

import com.goesbernardo.microservico_cadastro.entity.Cliente;
import com.goesbernardo.microservico_cadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {


    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente insertClient(Cliente cliente){

        return  clienteRepository.save(cliente);
    }

    public Cliente updateClient(Cliente cliente) {

        Optional<Cliente> newClient = clienteRepository.findById(cliente.getId());

        if(newClient.isPresent()){
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    public Boolean deleteClient(Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return true;
        } else {
            return false;
        }

    }

    public Optional<Cliente> findById(Long id) {

        return clienteRepository.findById(id);
    }
}
