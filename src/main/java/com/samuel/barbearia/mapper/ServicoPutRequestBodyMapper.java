package com.samuel.barbearia.mapper;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import org.modelmapper.ModelMapper;

public class ServicoPutRequestBodyMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ServicoPutRequestBody toServicoPutRequestBody(Servico servico){
        return  modelMapper.map(servico, ServicoPutRequestBody.class);
    }
}
