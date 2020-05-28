package com.roctiv.debtcontroll.api.dao;

import com.roctiv.debtcontroll.api.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAO extends AbstractJpaDAO<User> {

    public UserDAO(){
        super();
        setClazz(User.class);
    }

    public List<User> listUser(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public User getUserById(Long id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(cb.equal(root.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public User getUserByUsername(String username){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(cb.equal(root.get("username"), username));
        return entityManager.createQuery(query).getSingleResult();
    }



}
