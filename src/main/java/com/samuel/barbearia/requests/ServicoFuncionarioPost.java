package com.samuel.barbearia.requests;

import com.samuel.barbearia.requests.funcionario.Funcionario;
import com.samuel.barbearia.requests.servico.Servico;
import lombok.Data;

@Data
public class ServicoFuncionarioPost {
    private Servico servico;
    private Funcionario funcionario;
}
