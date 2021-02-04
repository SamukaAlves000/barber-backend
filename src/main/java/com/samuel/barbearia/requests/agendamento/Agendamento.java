package com.samuel.barbearia.requests.agendamento;

import com.samuel.barbearia.requests.funcionario.Funcionario;
import com.samuel.barbearia.requests.pessoa.Pessoa;
import com.samuel.barbearia.requests.servico.Servico;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Agendamento {

    private Long id;
    private LocalDate dataAgendamento;
    private LocalDateTime horario;
    private String status;
    private int avaliacao;
    private Funcionario funcionario;
    private Servico servico;
    private Pessoa pessoa;
}
