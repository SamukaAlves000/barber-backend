package com.samuel.barbearia.mapper.servico;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.requests.servico.ServicoRequest;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import org.modelmapper.ModelMapper;


public class ServicoMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ServicoRequest toServicoRequest(Servico servico){
        return modelMapper.map(servico, ServicoRequest.class);
    }

    public static Servico toServico(ServicoRequest servicoRequest){
        return modelMapper.map(servicoRequest, Servico.class);
    }

//    public static Servico toServico(com.samuel.barbearia.requests.servico.ServicoRequest servicoRequest){
//        return modelMapper.map(servicoRequest,Servico.class);
//    }

    public static Servico toServico(ServicoPostRequestBody servicoPostRequestBody){
        return  modelMapper.map(servicoPostRequestBody, Servico.class);
    }
    public static Servico toServico(ServicoPutRequestBody servicoPutRequestBody){
        return modelMapper.map(servicoPutRequestBody, Servico.class);
    }

    public static Servico toServico(com.samuel.barbearia.requests.servico.Servico servico){
        return modelMapper.map(servico,Servico.class);
    }
}
