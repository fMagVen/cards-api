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

import com.cardsapi.api.dto.CardsDTO;
import com.cardsapi.api.model.Card;
import com.cardsapi.api.repository.CardRepository;

import jakarta.validation.Valid;

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
    public void create(@RequestBody @Valid CardsDTO req){
        repository.save(new Card(req));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody @Valid CardsDTO req){
        repository.findById(id).map(card -> {
            card.setModelo(req.modelo());
            card.setFabricante(req.fabricante());
            card.setDataFabricacao(req.dataFabricacao());
            card.setValor(req.valor());
            card.setAnoModelo(req.anoModelo());
            return repository.save(card);
        });
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
