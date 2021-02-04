package com.samuel.barbearia.mapper.funcionario;


import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import org.modelmapper.ModelMapper;

public class FuncionarioMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static FuncionarioRequest toFuncionarioRequest(Funcionario funcionario){
        return modelMapper.map(funcionario, FuncionarioRequest.class);
    }
}
