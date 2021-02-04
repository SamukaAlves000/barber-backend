package com.samuel.barbearia.mapper.pessoa;

import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.requests.PessoaPutRequestBody;
import com.samuel.barbearia.requests.PessoaPostRequestBody;
import com.samuel.barbearia.requests.pessoa.PessoaRequest;
import org.modelmapper.ModelMapper;

public class PessoaMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static PessoaRequest toPessoaRequest(Pessoa pessoa){
        return modelMapper.map(pessoa, PessoaRequest.class);
    }

    public static Pessoa toPessoa(PessoaPostRequestBody pessoaPostRequestBody){
        return  modelMapper.map(pessoaPostRequestBody, Pessoa.class);
    }
    public static Pessoa toPessoa(PessoaPutRequestBody pessoaPutRequestBody){
        return  modelMapper.map(pessoaPutRequestBody, Pessoa.class);
    }

    public static PessoaPutRequestBody toPessoaPutRequestBody(Pessoa pessoa){
        return  modelMapper.map(pessoa, PessoaPutRequestBody.class);
    }
}
