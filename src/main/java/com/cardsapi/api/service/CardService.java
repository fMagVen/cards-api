package com.cardsapi.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsapi.api.dto.CardDTO;
import com.cardsapi.api.model.Card;
import com.cardsapi.api.repository.CardRepository;

@Service
public class CardService {
    
    @Autowired
    private CardRepository repository;

    public List<Card> findAll() {
        return repository.findAll();
    }

    public void save(CardDTO dto) {
        repository.save(new Card(dto));
    }

    public void update(long id, CardDTO req) {
       repository.findById(id).map(card -> {
            card.setModelo(req.modelo());
            card.setFabricante(req.fabricante());
            card.setDataFabricacao(req.dataFabricacao());
            card.setValor(req.valor());
            card.setAnoModelo(req.anoModelo());
            return repository.save(card);
        });
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
