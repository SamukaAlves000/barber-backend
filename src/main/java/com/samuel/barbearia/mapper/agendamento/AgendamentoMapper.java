package com.samuel.barbearia.mapper.agendamento;

import com.samuel.barbearia.domain.Agendamento;
import com.samuel.barbearia.requests.agendamento.AgendamentoRequest;
import org.modelmapper.ModelMapper;

public class AgendamentoMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static AgendamentoRequest toAgendamentoRequest(Agendamento agendamento){
        return modelMapper.map(agendamento, AgendamentoRequest.class);
    }

    public static Agendamento toAgendamento(AgendamentoRequest agendamentoRequest) {
        return modelMapper.map(agendamentoRequest, Agendamento.class);
    }
}
