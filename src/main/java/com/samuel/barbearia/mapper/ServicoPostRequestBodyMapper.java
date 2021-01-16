package com.samuel.barbearia.mapper;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import org.modelmapper.ModelMapper;

public class ServicoPostRequestBodyMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ServicoPostRequestBody toServicoPostRequestBody(Servico servico){
        return  modelMapper.map(servico, ServicoPostRequestBody.class);
    }
}
