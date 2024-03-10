package com.ms.tdd.controller;


import com.ms.tdd.model.Client;
import com.ms.tdd.repository.ClientRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public List<Client> list() {
        return repository.findAll();
        /* return Arrays.asList(Client.builder()
        .name("Mariana")
        .email("m"ariana.consolaro@gmail.com")
        .cel("989898998").build());
         */
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable String id){
        return repository.findById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client entity){
        entity.setId(ObjectId.get().toString());
        return repository.save(entity); //Salva usuário retornando instanciação
    }

    @PutMapping ("/{id}")
    public Client put(@RequestBody Client entity){
        entity.setId(ObjectId.get().toString());
        return repository.save(entity); // Atualiza o usuário
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        repository.deleteById(id);
        return null;
    }
}


