package com.samuel.barbearia.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@SuperBuilder
public class ServicoFuncionario {
    @EmbeddedId
    private ServicoFuncionarioKey id;

    @ManyToOne
    @MapsId("servicoId")
    @JoinColumn
    private Servico servico;

    @ManyToOne
    @MapsId("funcionarioId")
    @JoinColumn
    private Funcionario funcionario;
}
