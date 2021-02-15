package com.samuel.barbearia.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
public class Agendamento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAgendamento;
    private LocalDateTime horario;
    private String status;
    private int avaliacao;
    @ManyToOne
    @JoinColumn
    private Funcionario funcionario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Pessoa pessoa;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Servico servico;

}
