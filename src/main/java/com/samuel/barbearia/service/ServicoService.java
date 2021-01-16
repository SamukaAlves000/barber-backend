package com.samuel.barbearia.service;

import com.samuel.barbearia.domain.Servico;
import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.ServicoMapper;
import com.samuel.barbearia.repository.ServicoRepository;
import com.samuel.barbearia.requests.ServicoPostRequestBody;
import com.samuel.barbearia.requests.ServicoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public List<Servico> findAll (){
        return servicoRepository.findAll();
    }

    public Page<Servico> findAll (Pageable pageable){
        return servicoRepository.findAll(pageable);
    }

    public List<Servico> findAllByDescricao (String descricao){
        return servicoRepository.findAllByDescricao(descricao);
    }

    public Servico findById (Long id){
        return servicoRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    public Servico save (ServicoPostRequestBody servicoPostRequestBody){
        return servicoRepository.save(ServicoMapper.toServico(servicoPostRequestBody));
    }

    public void delete (Long id){
         servicoRepository.delete(this.findById(id));
    }

    public void replace (ServicoPutRequestBody servicoPutRequestBody){
         servicoRepository.save(ServicoMapper.toServico(servicoPutRequestBody));
    }

}
