package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Funcionario;
import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.domain.ServicoFuncionario;
import com.samuel.barbearia.domain.ServicoFuncionarioKey;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.funcionario.FuncionarioMapper;
import com.samuel.barbearia.mapper.servico.ServicoMapper;
import com.samuel.barbearia.repository.ServicoFuncionarioRepository;
import com.samuel.barbearia.repository.ServicoRepository;
import com.samuel.barbearia.repository.ServicoRepositoryImpl;
import com.samuel.barbearia.requests.servico.ServicoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ServicoFuncionarioRepository servicoFuncionarioRepository;
    public final ServicoRepositoryImpl teste;

    public List<ServicoRequest> findAllServicoRequest (){
        List<ServicoRequest>  servicoRequestList = servicoRepository.findAll()
                .stream().map(servico -> ServicoMapper.toServicoRequest(servico))
                .collect(Collectors.toList());
        return servicoRequestList;
    }

    public ServicoRequest findByIdServicoRequest (Long id){
        Servico servico = servicoRepository.findById(id).orElseThrow(() -> new BadRequestException("Servico not found"));
        ServicoRequest servicoRequest = ServicoMapper.toServicoRequest(servico);
        return  servicoRequest;
    }

    public void delete (Long id){
         servicoRepository.delete(servicoRepository.findById(id).orElseThrow(() -> new BadRequestException("Servico not found")));
    }

    public ServicoRequest save(ServicoRequest servicoRequest) {

        Servico servico = new Servico()
                .builder()
                .descricao(servicoRequest.getDescricao())
                .valor(servicoRequest.getValor())
                .duracao(servicoRequest.getDuracao())
                .build();
//        UPDATE
        if(servicoRequest.getId() != null){
            servico.setId(servicoRequest.getId());
            List<ServicoFuncionario> servicoFuncionarioListRemove = servicoFuncionarioRepository.findAll().stream().filter(
                    servicoFuncionario -> servicoFuncionario.getServico().getId() == servicoRequest.getId()).collect(Collectors.toList());
            servicoFuncionarioRepository.deleteAll(servicoFuncionarioListRemove);
        }

        Servico servicoSaved = servicoRepository.save(servico);

        if(servicoRequest.getFuncionarios() != null ){
            servicoRequest.getFuncionarios().forEach(servicoFuncionario -> {

                Funcionario funcionario = FuncionarioMapper.toFuncionario(servicoFuncionario.getFuncionario());

                ServicoFuncionarioKey servicoFuncionarioKey = new ServicoFuncionarioKey()
                        .builder()
                        .servicoId(servicoSaved.getId())
                        .funcionarioId(funcionario.getId())
                        .build();

                ServicoFuncionario servicoFuncionarioNovo = new ServicoFuncionario()
                        .builder()
                        .servico(servicoSaved)
                        .funcionario(funcionario)
                        .id(servicoFuncionarioKey)
                        .build();

                servicoFuncionarioRepository.save(servicoFuncionarioNovo);
            });
        }

        servicoRequest.setId(servicoSaved.getId());

        return servicoRequest;
    }

}
