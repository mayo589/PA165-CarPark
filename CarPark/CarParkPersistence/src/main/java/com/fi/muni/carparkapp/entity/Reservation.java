/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fi.muni.carparkapp.entity;

//import cz.fi.muni.pa165.enums.OrderState;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan Starka
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @NotNull
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    private Car car;

    @ManyToOne(optional = false)
    @NotNull
    private Office office;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    
    @NotNull
    private boolean cancelled;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Reservation(Long id) {
        this.id = id;
    }

    public Reservation() {
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employee == null) ? 0 : employee.hashCode());
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((office == null) ? 0 : office.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Reservation other = (Reservation) obj;
        if (employee == null) {
            if (other.employee != null) {
                return false;
            }
        } else if (!employee.equals(other.employee)) {
            return false;
        }
        if (car != other.car) {
            return false;
        }
        if (office == null) {
            if (other.office != null) {
                return false;
            }
        } else if (!office.equals(other.office)) {
            return false;
        }
        return true;
    }
}
