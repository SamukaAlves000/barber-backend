package com.samuel.barbearia.mapper;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import org.modelmapper.ModelMapper;


public class ServicoMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Servico toServico(ServicoPostRequestBody servicoPostRequestBody){
        return  modelMapper.map(servicoPostRequestBody, Servico.class);
    }
    public static Servico toServico(ServicoPutRequestBody servicoPutRequestBody){
        return modelMapper.map(servicoPutRequestBody, Servico.class);
    }
}
