package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.*;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.funcionario.FuncionarioMapper;
import com.samuel.barbearia.mapper.pessoa.PessoaMapper;
import com.samuel.barbearia.mapper.servico.ServicoMapper;
import com.samuel.barbearia.repository.FuncionarioRepository;
import com.samuel.barbearia.repository.ServicoFuncionarioRepository;
import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ServicoFuncionarioRepository servicoFuncionarioRepository;

    public List<FuncionarioRequest> findAll (){
        List<FuncionarioRequest> funcionarioRequestList = funcionarioRepository.findAll()
                .stream().map(funcionario -> FuncionarioMapper.toFuncionarioRequest(funcionario))
                .collect(Collectors.toList());
        return funcionarioRequestList;
    }

    public Page<Funcionario> findAll (Pageable pageable){
        return funcionarioRepository.findAll(pageable);
    }

    public FuncionarioRequest findById (Long id){
        return FuncionarioMapper.toFuncionarioRequest(funcionarioRepository.findById(id).orElseThrow(() -> new BadRequestException("Funcionario not found")));
    }

    public FuncionarioRequest save (FuncionarioRequest funcionarioRequest){

        Pessoa pessoa = PessoaMapper.toPessoa(funcionarioRequest.getPessoa());
        Funcionario funcionario = new Funcionario()
                .builder()
                .pessoa(pessoa)
                .salario(funcionarioRequest.getSalario())
                .build();

        //UPDATE
        if(funcionarioRequest.getId() != null) {
            funcionario.setId(funcionarioRequest.getId());
            List<ServicoFuncionario> servicoFuncionarioListRemove = servicoFuncionarioRepository.findAll().stream().filter(
                    servicoFuncionario -> servicoFuncionario.getFuncionario().getId() == funcionarioRequest.getId()).collect(Collectors.toList());
            servicoFuncionarioRepository.deleteAll(servicoFuncionarioListRemove);
        }

        Funcionario funcionarioSaved = this.funcionarioRepository.save(funcionario);

        if (funcionarioRequest.getServicos() != null ){

            funcionarioRequest.getServicos().forEach(servicoFuncionario -> {

                Servico servico = ServicoMapper.toServico(servicoFuncionario.getServico());

                ServicoFuncionarioKey servicoFuncionarioKey = new ServicoFuncionarioKey()
                        .builder()
                        .servicoId(servico.getId())
                        .funcionarioId(funcionarioSaved.getId())
                        .build();

                ServicoFuncionario servicoFuncionarioNovo = new ServicoFuncionario()
                        .builder()
                        .servico(servico)
                        .funcionario(funcionarioSaved)
                        .id(servicoFuncionarioKey)
                        .build();

                servicoFuncionarioRepository.save(servicoFuncionarioNovo);

            });
        }

        funcionarioRequest.setId(funcionarioSaved.getId());
        funcionarioRequest.getPessoa().setId(funcionarioSaved.getId());

        return  funcionarioRequest;
    }

    public void delete (Long id){
        funcionarioRepository.delete(funcionarioRepository.findById(id).orElseThrow(() -> new BadRequestException("Funcionario not found")));
    }
}
