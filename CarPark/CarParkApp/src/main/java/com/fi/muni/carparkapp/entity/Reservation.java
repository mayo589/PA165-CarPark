/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fi.muni.carparkapp.entity;

//import cz.fi.muni.pa165.enums.OrderState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan Starka
 */

@Entity
@Table(name="RESERVATION")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false)
	@NotNull
	private Employee employee;
        
        @ManyToOne(optional=false)
	@NotNull
	private Car car;
        
        @ManyToOne(optional=false)
	@NotNull
	private Office office;
	
	/*@OneToMany
	@NotNull
	private List<OrderItem> reservationItems = new ArrayList<OrderItem>();*/
		
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
        
        @NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	/*@Enumerated
	@NotNull
	private OrderState state;*/

	public Reservation(Long id) {
		this.id=id;
	}

	public Reservation() {
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/*public List<OrderItem> getOrderItems() {
		return Collections.unmodifiableList(orderItems);
	}

	public void addOrderItem(OrderItem p) {
		orderItems.add(p);
	}*/

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/*public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}*/

	public Long getId() {
		return id;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}*/

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (state != other.state)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}*/
}

