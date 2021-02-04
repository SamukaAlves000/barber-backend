package com.samuel.barbearia.requests.servico;

import lombok.Data;

@Data
public class Servico {
    private Long id;
    private String descricao;
    private double valor;
    private int duracao;
}
