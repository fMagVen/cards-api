package com.cardsapi.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CardsDTO(
    
@NotBlank
String modelo, 

@NotBlank
String fabricante,

@Past
Date dataFabricacao,

@NotNull
float valor, 

@NotNull
int anoModelo) {
    
}
