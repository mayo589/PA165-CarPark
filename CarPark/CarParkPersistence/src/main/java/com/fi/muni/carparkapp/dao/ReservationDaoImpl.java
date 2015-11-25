package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Car;
import com.fi.muni.carparkapp.entity.Employee;
import com.fi.muni.carparkapp.entity.Office;
import com.fi.muni.carparkapp.entity.Reservation;
import java.util.Date;
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
    public void create(Reservation o) {
        em.persist(o);
    }

    @Override
    public void delete(Reservation o) {
        em.remove(o);
    }

    @Override
    public void update(Reservation o) {
        em.merge(o);
    }

    @Override
    public Reservation findById(Long id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> findAll() {
        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();
    }

    @Override
    public List<Reservation> findByEmployee(Employee employee) {
        try {
            return em.createQuery("select r from Reservation r where employee = :employee",
                    Reservation.class).setParameter("employee", employee).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Reservation> findByCar(Car car) {
        try {
            return em.createQuery("select r from Reservation r where car = :car",
                    Reservation.class).setParameter("car", car).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Reservation> findByOffice(Office office) {
        try {
            return em.createQuery("select r from Reservation r where office = :office",
                    Reservation.class).setParameter("office", office).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Reservation> findByDateRange(Date fromDate, Date toDate) {
        try {
            return em.createQuery("select r from Reservation r where fromDate >= :fromDate AND toDate <= :toDate",
                    Reservation.class)
                    .setParameter("fromDate", fromDate)
                    .setParameter("toDate", toDate)
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
