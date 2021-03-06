package com.samuel.barbearia.requests;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class ServicoPostRequestBody {
    @NotEmpty (message = "O campo descricao é obrigatório")
    private String descricao;
    @Min(value = 1,message = "O campo valor é obrigatório")
    private double valor;
    private int duracao;
}
