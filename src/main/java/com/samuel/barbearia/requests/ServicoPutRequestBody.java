package com.samuel.barbearia.requests;

import lombok.Data;

@Data
public class ServicoPutRequestBody {

    private Long id;
    private String descricao;
    private double valor;
    private int duracao;
}
