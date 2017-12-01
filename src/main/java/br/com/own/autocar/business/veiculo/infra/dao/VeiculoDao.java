package br.com.own.autocar.business.veiculo.infra.dao;

import br.com.own.autocar.business.veiculo.domain.model.Veiculo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VeiculoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Veiculo obterPacientePorId(Long id) {
        String hql = "select p from Veiculo p where p.id = :id";

        return (Veiculo) entityManager.createQuery(hql)
                        .setParameter("id", id)
                        .getSingleResult();

    }

}
