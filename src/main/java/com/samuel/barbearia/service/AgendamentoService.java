package com.samuel.barbearia.service;

import com.samuel.barbearia.mapper.agendamento.AgendamentoMapper;
import com.samuel.barbearia.repository.AgendamentoRepository;
import com.samuel.barbearia.domain.Agendamento;
import com.samuel.barbearia.requests.agendamento.AgendamentoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public List<AgendamentoRequest> findAll (){
        List<AgendamentoRequest> agendamentoRequest = agendamentoRepository.findAll()
                .stream().map(agendamento -> AgendamentoMapper.toAgendamentoRequest(agendamento))
                .collect(Collectors.toList());
        return agendamentoRequest;
    }

    public List<AgendamentoRequest> findAllStatus (String status){
        List<AgendamentoRequest> agendamentoRequest = agendamentoRepository.findAllByStatusOrderByDataAgendamento(status)
                .stream().map(agendamento -> AgendamentoMapper.toAgendamentoRequest(agendamento))
                .collect(Collectors.toList());
        return agendamentoRequest;
    }

    public AgendamentoRequest save(AgendamentoRequest agendamentoRequest) {
        Agendamento agendamento = AgendamentoMapper.toAgendamento(agendamentoRequest);
        return AgendamentoMapper.toAgendamentoRequest(agendamentoRepository.save(agendamento));
    }
}
