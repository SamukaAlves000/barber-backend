package com.samuel.barbearia.requests.agendamento;

import com.samuel.barbearia.requests.funcionario.Funcionario;
import com.samuel.barbearia.requests.servico.Servico;
import com.samuel.barbearia.requests.servico.ServicoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class AgendamentoRequest extends Agendamento{
}
