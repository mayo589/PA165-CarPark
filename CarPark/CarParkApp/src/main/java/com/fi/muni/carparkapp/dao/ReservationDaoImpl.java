package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
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

    /**
     *
     * @param o
     */
    @Override
    public void create(Reservation o) {
        em.persist(o);
    }

    @Override
    public void delete(Reservation o) {
        em.remove(o);
    }

    @Override
    public Reservation findByEmployee(Employee employee) {
        try {
            return em.createQuery("select c from Reservation o where employee = :employee",
                    Reservation.class).setParameter(":employee", employee).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Reservation findByCar(Car car) {
        try {
            return em.createQuery("select c from Reservation o where car = :car",
                    Reservation.class).setParameter(":car", car).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Reservation findByOffice(Office office) {
        try {
            return em.createQuery("select c from Reservation o where office = :office",
                    Reservation.class).setParameter(":office", office).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
