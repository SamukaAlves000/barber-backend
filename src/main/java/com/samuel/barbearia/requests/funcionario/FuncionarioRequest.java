package com.samuel.barbearia.requests.funcionario;

import com.samuel.barbearia.requests.pessoa.Pessoa;
import lombok.Data;

import java.util.List;

@Data
public class FuncionarioRequest {

    private Long id;
    private double salario;
    private Pessoa pessoa;
    private List<ServicoFuncionario> servicos;

}
