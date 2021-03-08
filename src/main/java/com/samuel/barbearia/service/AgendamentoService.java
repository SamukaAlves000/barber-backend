package com.samuel.barbearia.service;

import com.samuel.barbearia.exception.BadRequestException;
import com.samuel.barbearia.mapper.agendamento.AgendamentoMapper;
import com.samuel.barbearia.mapper.funcionario.FuncionarioMapper;
import com.samuel.barbearia.repository.AgendamentoRepository;
import com.samuel.barbearia.domain.Agendamento;
import com.samuel.barbearia.requests.agendamento.AgendamentoRequest;
import com.samuel.barbearia.requests.funcionario.FuncionarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
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

    public AgendamentoRequest findById (Long id){
        return AgendamentoMapper.toAgendamentoRequest(agendamentoRepository.findById(id).orElseThrow(() -> new BadRequestException("Agendamento not found")));
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

    public List<LocalDateTime> findHorarios (String data){
        List<String> stringList = new ArrayList<>();

        stringList.add("PENDENTE");
        stringList.add("ACEITO/CONFIRMADO");
        int dia = Integer.parseInt(data.split("-")[2]);
        int mes = Integer.parseInt(data.split("-")[1]);
        int ano = Integer.parseInt(data.split("-")[0]);

        LocalDate localDate = LocalDate.of(ano, mes, dia);
        List<LocalDateTime> list = agendamentoRepository
                .findAllByDataAgendamentoAndStatusIn(localDate,stringList)
                .stream().map(Agendamento::getHorario).collect(Collectors.toList());
        return list;
    }
}
