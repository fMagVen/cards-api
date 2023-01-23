package com.cardsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardsapi.api.dto.CardDTO;
import com.cardsapi.api.model.Card;
import com.cardsapi.api.service.CardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cards")
public class Cardcontroller {

    @Autowired
    private CardService service;

    @PostMapping
    public void save(@RequestBody @Valid CardDTO req){
        service.save(req);
    }

    @GetMapping
    public List<Card> listAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody @Valid CardDTO req){
        service.update(id, req);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
