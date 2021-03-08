package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.Servico;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

public class ServicoRepositoryImpl{
    @PersistenceContext
    EntityManager em = null;
    //    public List<Servico> findAllByDescricao(String descricao);
    public List<Servico> testeSamuel(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Servico> cq = cb.createQuery(Servico.class);

        Root<Servico> book = cq.from(Servico.class);
        book.fetch("funcionarios", JoinType.LEFT);
        cq.select(book);
        TypedQuery<Servico> query = em.createQuery(cq);
        return  query.getResultList();
    }
}
