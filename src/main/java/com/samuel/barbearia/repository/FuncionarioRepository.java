package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
