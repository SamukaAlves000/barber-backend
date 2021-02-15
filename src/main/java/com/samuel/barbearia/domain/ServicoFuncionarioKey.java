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

    @Column
    private Long servicoId;

    @Column
    private Long funcionarioId;


}
