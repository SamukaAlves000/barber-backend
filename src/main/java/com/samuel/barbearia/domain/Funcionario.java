package com.samuel.barbearia.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double salario;
    @OneToOne
    @MapsId
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToMany(mappedBy = "funcionarios")
    private List<Servico> servicos;
    @OneToMany(mappedBy="funcionario")
    private List<Agendamento> agendamentos;
}
