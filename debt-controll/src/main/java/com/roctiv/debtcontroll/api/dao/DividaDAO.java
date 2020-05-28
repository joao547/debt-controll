package com.roctiv.debtcontroll.api.dao;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DividaDAO extends AbstractJpaDAO<Divida> {

    public DividaDAO(){
        super();
        setClazz(Divida.class);
    }

    public List<Divida> listByUser(User user){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Divida> query = cb.createQuery(Divida.class);
        Root<Divida> root = query.from(Divida.class);

        Predicate predicate = cb.equal(root.get("user"),user);

        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    public Divida listById(Long id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Divida> query = cb.createQuery(Divida.class);
        Root<Divida> root = query.from(Divida.class);

        Predicate predicate = cb.equal(root.get("id"),id);

        query.where(predicate);

        return entityManager.createQuery(query).getSingleResult();
    }
}
