package com.samuel.barbearia.mapper;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;

@Mapper(componentModel = "spring")
public class ServicoMapper {

    ModelMapper modelMapper = new ModelMapper();

    public static final ServicoMapper  INSTANCE = Mappers.getMapper( ServicoMapper .class );
    public   Servico toServico(ServicoPostRequestBody servicoPostRequestBody){
        return  modelMapper.map(servicoPostRequestBody, Servico.class);
    }
    public  Servico toServico1(ServicoPutRequestBody servicoPutRequestBody){
        return modelMapper.map(servicoPutRequestBody, Servico.class);
    }
}
