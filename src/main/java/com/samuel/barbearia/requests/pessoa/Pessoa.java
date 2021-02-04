package com.samuel.barbearia.requests.pessoa;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pessoa {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String fone;
    private String cidade;
    private String uf;
    private String sexo;
    private LocalDate dataNasc;
}
