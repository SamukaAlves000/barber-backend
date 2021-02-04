package com.samuel.barbearia.requests.servico;

import com.samuel.barbearia.requests.funcionario.Funcionario;
import lombok.Data;

import java.util.List;

@Data
public class ServicoRequest extends Servico{
    private List<Funcionario> funcionarios;
}
