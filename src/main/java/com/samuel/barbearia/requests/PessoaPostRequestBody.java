package com.samuel.barbearia.requests;

import com.samuel.barbearia.domain.Funcionario;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PessoaPostRequestBody {

    private String nome;
    private String email;
    private String cpf;
    private String fone;
    private String cidade;
    private String uf;
    private String sexo;
    private LocalDate dataNasc;
    private Funcionario funcionario;
}
