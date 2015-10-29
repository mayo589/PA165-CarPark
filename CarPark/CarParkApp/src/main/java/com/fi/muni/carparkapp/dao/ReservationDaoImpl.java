package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Reservation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jan Starka
 */
@Repository
public class ReservationDaoImpl implements ReservationDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Reservation findById(Long id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> findAll() {
        return em.createQuery("select o from Office o", Reservation.class)
                .getResultList();
    }

    @Override
    public Reservation findByName(String name) {
        try {
            return em.createQuery("select c from Office o where name = :name",
                    Reservation.class).setParameter(":name", name).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void create(Reservation o) {
        em.persist(o);
    }

    @Override
    public void delete(Reservation o) {
        em.remove(o);
    }
    
}
