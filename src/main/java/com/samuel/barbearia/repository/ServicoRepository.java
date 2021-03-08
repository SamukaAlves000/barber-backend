package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Long> {

}
