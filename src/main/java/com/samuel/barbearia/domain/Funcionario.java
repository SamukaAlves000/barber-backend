package com.samuel.barbearia.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
    List<ServicoFuncionario> servicos;
    @OneToMany(mappedBy="funcionario")
    private List<Agendamento> agendamentos;
}
