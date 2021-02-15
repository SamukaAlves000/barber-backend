package com.samuel.barbearia.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@SuperBuilder
public class ServicoFuncionarioKey implements Serializable {

    @Column(name = "servico_id")
    private Long servicoId;

    @Column(name = "funcionario_id")
    private Long funcionarioId;


}
