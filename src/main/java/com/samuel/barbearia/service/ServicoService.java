package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.servico.ServicoMapper;
import com.samuel.barbearia.repository.ServicoRepository;
import com.samuel.barbearia.requests.servico.ServicoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public List<Servico> findAll (){
        return servicoRepository.findAll();
    }

    public List<ServicoRequest> findAllServicoRequest (){
        List<ServicoRequest>  servicoRequestList = servicoRepository.findAll()
                .stream().map(servico -> ServicoMapper.toServicoRequest(servico))
                .collect(Collectors.toList());
        return servicoRequestList;
    }

    public Page<Servico> findAll (Pageable pageable){
        return servicoRepository.findAll(pageable);
    }

    public List<Servico> findAllByDescricao (String descricao){
        return servicoRepository.findAllByDescricao(descricao);
    }

    public ServicoRequest findById (Long id){
        Servico servico = servicoRepository.findById(id).orElseThrow(() -> new BadRequestException("Servico not found"));
        ServicoRequest servicoRequest = ServicoMapper.toServicoRequest(servico);
        return  servicoRequest;
    }

    public ServicoRequest save (ServicoRequest servicoRequest){
        Servico  servico = servicoRepository.save(ServicoMapper.toServico(servicoRequest));
        ServicoRequest servicoSaved = ServicoMapper.toServicoRequest(servico);
        return servicoSaved;
    }

    public void delete (Long id){
         servicoRepository.delete(servicoRepository.findById(id).orElseThrow(() -> new BadRequestException("Servico not found")));
    }

    public void replace (ServicoRequest servicoRequest){
        servicoRepository.save(ServicoMapper.toServico(servicoRequest));
    }

}
