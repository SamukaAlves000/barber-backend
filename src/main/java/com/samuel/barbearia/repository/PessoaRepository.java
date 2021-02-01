package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Pessoa;
import com.samuel.barbearia.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    public List<Pessoa> findAllByEmail(String email);
}
