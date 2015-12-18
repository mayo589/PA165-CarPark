package com.fi.muni.carparkapp.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan Hellar (436358)
 */
@Entity
public class Office {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(nullable=false)
    private String name;
    
    @NotNull
    @Column(nullable=false)
    private String address;
    
    //@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    //@NotNull
    //private List<Reservation> reservations;
    
    public Office(Long officeId) {
        //this.reservations = new ArrayList<>();
        this.id = officeId;
    }
    
    public Office() {
        //this.reservations = new ArrayList<>();
    }
    
   /* public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
    
    public void addReservation(Reservation r) {
        reservations.add(r);
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Office other = (Office) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
    
}
