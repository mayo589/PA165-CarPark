package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.exceptions.SimpleDataAccessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jan Hellar (436358)
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Office findById(Long id) {
        if (id == null) {
            throw new SimpleDataAccessException("id cannot be null");
        }
        if (id < 0) {
            throw new SimpleDataAccessException("id cannot be < 0");
        }
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> findAll() {
        return em.createQuery("select o from Office o", Office.class)
                .getResultList();
    }

    @Override
    public Office findByName(String name) {
        if (name == null) {
            throw new SimpleDataAccessException("name cannot be null");
        }
        if (name == "") {
            throw new SimpleDataAccessException("name cannot be empty");
        }
        try {
            return em.createQuery("select o from Office o where name = :name",
                    Office.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    @Override
    public Office findByAddress(String address) {
        if (address == null) {
            throw new SimpleDataAccessException("address cannot be null");
        }
        if (address == "") {
            throw new SimpleDataAccessException("address cannot be empty");
        }
        try {
            return em.createQuery("select o from Office o where address = :address",
                    Office.class).setParameter("address", address).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void create(Office o) {
        if (o == null) {
            throw new SimpleDataAccessException("office cannot be null");
        }
        em.persist(o);
    }

    @Override
    public void delete(Office o) {
        if (o == null) {
            throw new SimpleDataAccessException("office cannot be null");
        }
        em.remove(o);
    }
    
}
