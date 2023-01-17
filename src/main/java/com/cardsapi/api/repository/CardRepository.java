package com.cardsapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardsapi.api.model.Card;

public interface CardRepository extends JpaRepository<Card,Long> {
    
}
