package com.cardsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardsapi.api.dto.CardsDTO;
import com.cardsapi.api.model.Card;
import com.cardsapi.api.repository.CardRepository;

@RestController
@RequestMapping("/api/cards")
public class Cardscontroller {

    @Autowired
    private CardRepository repository;

    @GetMapping
    public List<Card> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody CardsDTO req){
        repository.save(new Card(req));
    }
}
