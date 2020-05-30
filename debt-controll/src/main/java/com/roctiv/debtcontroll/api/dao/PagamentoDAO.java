package com.roctiv.debtcontroll.api.dao;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.Pagamento;
import com.roctiv.debtcontroll.api.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public List<Pagamento> listByUser(User user){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pagamento> query = cb.createQuery(Pagamento.class);
        Root<Pagamento> from = query.from(Pagamento.class);
        Join<Pagamento, Divida> dividaJoin = from.join("divida");

        Path<User> users = dividaJoin.get("user");
        Predicate predicate = cb.equal(users,user);

        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Pagamento> listByUserAndMonth(User user, Integer mes, Integer ano){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pagamento> query = cb.createQuery(Pagamento.class);
        Root<Pagamento> from = query.from(Pagamento.class);
        Join<Pagamento, Divida> dividaJoin = from.join("divida");

        List<Predicate> predicates = new ArrayList<>();

        Path<User> users = dividaJoin.get("user");
        Predicate predicateUser = cb.equal(users,user);
        predicates.add(predicateUser);

        Predicate predicateMonth = cb.equal(cb.function("MONTH", Integer.class, from.get("dataDaParcela")),mes);
        predicates.add(predicateMonth);
        Predicate predicateYear = cb.equal(cb.function("YEAR", Integer.class, from.get("dataDaParcela")),ano);
        predicates.add(predicateYear);

        Predicate[] predicate = new Predicate[predicates.size()];
        predicates.toArray(predicate);

        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

}
