package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Long> {

    public List<Servico> findAllByDescricao(String descricao);
}
