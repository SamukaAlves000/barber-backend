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
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double valor;
    private int duracao;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "servico_funcionario",
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> funcionarios;
    @OneToMany(mappedBy="servico")
    private List<Agendamento> agendamentos;
}
