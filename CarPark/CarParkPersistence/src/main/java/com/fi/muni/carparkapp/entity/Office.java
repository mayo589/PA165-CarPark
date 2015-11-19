package com.fi.muni.carparkapp.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(nullable=false,unique=true)
    private String name;
    
    @NotNull
    @Column(nullable=false)
    private String address;
    
    @OneToMany
    @NotNull
    private List<Reservation> reservations = new ArrayList<Reservation>();
    
    public Office(Long officeId) {
        this.id = officeId;
    }
    
    public Office() {
    }
    
    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
    
    public void addReservation(Reservation r) {
        reservations.add(r);
    }

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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Office))
            return false;
        Office other = (Office)obj;
        if (name == null) {
            if (other.getName() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;
        if (address == null) {
            if (other.getAddress() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;
        return true;
    }
    
}
