package com.samuel.barbearia.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String fone;
    private String cidade;
    private String uf;
    private String sexo;
    private LocalDate dataNasc;
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Funcionario funcionario;
    @OneToMany(mappedBy="pessoa")
    private List<Agendamento> agendamentos;
}
