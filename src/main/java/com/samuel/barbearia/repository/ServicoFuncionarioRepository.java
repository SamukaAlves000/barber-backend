package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.ServicoFuncionario;
import com.samuel.barbearia.domain.ServicoFuncionarioKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoFuncionarioRepository extends JpaRepository<ServicoFuncionario, ServicoFuncionarioKey> {
}
