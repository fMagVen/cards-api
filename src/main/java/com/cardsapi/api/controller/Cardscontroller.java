package com.cardsapi.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardsapi.api.dto.CardsDTO;

@RestController
@RequestMapping("/api/cards")
public class Cardscontroller {
    
    @PostMapping
    public void create(@RequestBody CardsDTO req){
        System.out.println(req);
    }
}
