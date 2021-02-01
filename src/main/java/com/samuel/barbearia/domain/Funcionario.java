package com.samuel.barbearia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
    @JsonIgnore
    private Pessoa pessoa;
}
