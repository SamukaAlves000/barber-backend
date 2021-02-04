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
    @JoinColumn(name="funcionario_id", nullable=false)
    private Funcionario funcionario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pessoa_id", nullable=false)
    private Pessoa pessoa;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="servico_id", nullable=false)
    private Servico servico;

}
