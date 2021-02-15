package com.samuel.barbearia.requests.servico;

import com.samuel.barbearia.requests.servico.ServicoFuncionario;
import lombok.Data;

import java.util.List;

@Data
public class ServicoRequest {

    private Long id;
    private String descricao;
    private double valor;
    private int duracao;
    private List<ServicoFuncionario> funcionarios;
}
