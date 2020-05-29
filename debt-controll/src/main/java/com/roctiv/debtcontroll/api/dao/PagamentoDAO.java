package com.roctiv.debtcontroll.api.dao;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.Pagamento;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PagamentoDAO extends AbstractJpaDAO<Pagamento> {

    public PagamentoDAO(){
        super();
        setClazz(Pagamento.class);
    }

    public List<Pagamento> listByDivida(Divida divida){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pagamento> query = cb.createQuery(Pagamento.class);
        Root<Pagamento> root = query.from(Pagamento.class);

        Predicate predicate = cb.equal(root.get("divida"),divida);

        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

}
