package com.samuel.barbearia.requests.servico;

import com.samuel.barbearia.requests.funcionario.Funcionario;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServicoRequest extends Servico{
    private List<Funcionario> funcionarios;
}
