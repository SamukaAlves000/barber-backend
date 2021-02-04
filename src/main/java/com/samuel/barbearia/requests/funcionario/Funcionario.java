package com.samuel.barbearia.requests.funcionario;

import com.samuel.barbearia.requests.pessoa.Pessoa;
import lombok.Data;

@Data
public class Funcionario {
    private Long id;
    private double salario;
    private Pessoa pessoa;
}
