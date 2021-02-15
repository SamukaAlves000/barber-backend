package com.samuel.barbearia.mapper.funcionario;


import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import org.modelmapper.ModelMapper;

public class FuncionarioMapper {

    private static ModelMapper modelMapper = new ModelMapper();
    public static FuncionarioRequest toFuncionarioRequest(Funcionario funcionario){
        return modelMapper.map(funcionario, FuncionarioRequest.class);
    }


    public static Funcionario toFuncionario(FuncionarioRequest funcionarioRequest) {
        return modelMapper.map(funcionarioRequest,Funcionario.class);
    }

    public static Funcionario toFuncionario(com.samuel.barbearia.requests.funcionario.Funcionario funcionario) {
        return modelMapper.map(funcionario,Funcionario.class);
    }

    public static Pessoa toPessoa(com.samuel.barbearia.requests.pessoa.Pessoa pessoa) {
        return modelMapper.map(pessoa,Pessoa.class);
    }
}
