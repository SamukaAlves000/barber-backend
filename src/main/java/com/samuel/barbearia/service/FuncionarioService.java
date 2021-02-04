package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.funcionario.FuncionarioMapper;
import com.samuel.barbearia.repository.FuncionarioRepository;
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

    public List<FuncionarioRequest> findAll (){
        List<FuncionarioRequest> funcionarioRequestList = funcionarioRepository.findAll()
                .stream().map(funcionario -> FuncionarioMapper.toFuncionarioRequest(funcionario))
                .collect(Collectors.toList());
        return funcionarioRequestList;
    }

    public Page<Funcionario> findAll (Pageable pageable){
        return funcionarioRepository.findAll(pageable);
    }

    public Funcionario findById (Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new BadRequestException("Funcionario not found"));
    }

    public Funcionario save (Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void delete (Long id){
        funcionarioRepository.delete(this.findById(id));
    }

    public void replace (Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }
}
