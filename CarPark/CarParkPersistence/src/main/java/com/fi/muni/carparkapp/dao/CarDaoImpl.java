/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.dao;

import com.fi.muni.carparkapp.entity.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marek Mihalech
 */
@Repository
public class CarDaoImpl implements CarDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Car findById(Long id) {
        return em.find(Car.class, id);
    }
    
    @Override
    public Car findByVin(String vin) {
        List<Car> resultList = em.createQuery("SELECT c FROM Car c where c.vin = :vin", Car.class)
                .setParameter("vin", vin).getResultList();
        return resultList.get(0);
    }
    
    @Override
    public void create(Car c) {
        em.persist(c);
    }

    @Override
    public void delete(Car c) {
        em.remove(c);
    }

    @Override
    public List<Car> findAll() {
        return em.createQuery("select c from Car c", Car.class).getResultList();
    }

    @Override
    public void update(Car c) {
        em.merge(c);
    }
    
}
