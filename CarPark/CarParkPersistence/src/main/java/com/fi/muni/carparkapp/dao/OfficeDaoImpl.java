package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Office;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

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
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> findAll() {
        return em.createQuery("select o from Office o", Office.class)
                .getResultList();
    }

    @Override
    public Office findByName(String name) {
        try {
            return em.createQuery("select o from Office o where name = :name",
                    Office.class).setParameter("name", name).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    @Override
    public Office findByAddress(String address) {
        try {
            return em.createQuery("select o from Office o where address = :address",
                    Office.class).setParameter("address", address).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void create(Office o) {
        em.persist(o);
    }

    @Override
    public void delete(Office o) {
        em.remove(o);
    }
    
}
