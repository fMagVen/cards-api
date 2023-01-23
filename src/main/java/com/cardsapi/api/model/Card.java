package com.cardsapi.api.model;

import java.util.Date;

import com.cardsapi.api.dto.CardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Card {

    public Card(CardDTO data){
        this.modelo = data.modelo();
        this.fabricante = data.fabricante();
        this.dataFabricacao = data.dataFabricacao();
        this.valor = data.valor();
        this.anoModelo = data.anoModelo();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255, nullable = false  )
    private String modelo;

    @Column(length = 255, nullable = false  )
    private String fabricante;

    @Column( nullable = false  )
    private Date dataFabricacao;

    @Column(length = 10, nullable = false  )
    private float valor;

    @Column(length = 4, nullable = false  )
    private int anoModelo;
}