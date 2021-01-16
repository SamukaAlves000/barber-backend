package com.samuel.barbearia.util;

import com.samuel.barbearia.domain.Servico;

public class ServicoCreator {

    public static Servico createServicoSaved(){

        return  new Servico().builder()
                .descricao("Corte Simples")
                .duracao(30)
                .valor(20)
                .build();
    }

    public static Servico createServicoValid(){

        return  new Servico().builder()
                .id(1L)
                .descricao("Corte Simples")
                .duracao(30)
                .valor(20)
                .build();
    }

    public static Servico createServicoUpate(){

        return  new Servico().builder()
                .id(1L)
                .descricao("Corte Simples 2")
                .duracao(30)
                .valor(20)
                .build();
    }
}
