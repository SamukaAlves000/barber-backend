package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.ServicoFuncionario;
import com.samuel.barbearia.repository.ServicoFuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicoFuncionarioService {

    private final ServicoFuncionarioRepository servicoFuncionarioRepository;

    public ServicoFuncionario save(ServicoFuncionario servicoFuncionario){
       ServicoFuncionario servicoFuncionariosaved = this.servicoFuncionarioRepository.save(servicoFuncionario);
        return servicoFuncionariosaved;
    }
}
