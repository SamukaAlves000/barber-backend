package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

    List<Agendamento> findAllByStatusOrderByDataAgendamento(String status);
    List<Agendamento> findAllByDataAgendamentoAndStatusIn(LocalDate dataAgendamento, Collection<String> status);
}
