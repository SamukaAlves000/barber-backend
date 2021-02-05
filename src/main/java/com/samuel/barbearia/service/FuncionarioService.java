package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.funcionario.FuncionarioMapper;
import com.samuel.barbearia.mapper.servico.ServicoMapper;
import com.samuel.barbearia.repository.FuncionarioRepository;
import com.samuel.barbearia.repository.PessoaRepository;
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
    private final PessoaRepository pessoaRepository;

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
        Funcionario funcionario = FuncionarioMapper.toFuncionario(funcionarioRequest);
        funcionario.getPessoa().setFuncionario(null);
        FuncionarioRequest funcionarioRequestSaved =    FuncionarioMapper.toFuncionarioRequest(funcionarioRepository.save(funcionario));
        return funcionarioRequestSaved;
    }

    public void delete (Long id){
        funcionarioRepository.delete(FuncionarioMapper.toFuncionario(this.findById(id)));
    }

    public void replace (FuncionarioRequest funcionarioRequest){
        funcionarioRepository.save(FuncionarioMapper.toFuncionario(funcionarioRequest));
    }
}
