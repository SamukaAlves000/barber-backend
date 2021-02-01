package com.samuel.barbearia.requests;

import com.samuel.barbearia.domain.Funcionario;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class PessoaPutRequestBody implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String fone;
    private String cidade;
    private String uf;
    private char sexo;
    private LocalDate dataNasc;
    private Funcionario funcionario;
}
