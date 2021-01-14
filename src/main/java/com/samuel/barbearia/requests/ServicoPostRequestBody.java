package com.samuel.barbearia.requests;

import lombok.Data;

@Data
public class ServicoPostRequestBody {
    private String descricao;
    private double valor;
    private int duracao;
}
