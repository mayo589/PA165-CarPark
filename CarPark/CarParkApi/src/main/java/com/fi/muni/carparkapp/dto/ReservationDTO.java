package com.fi.muni.carparkapp.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Jan Starka
 */
public class ReservationDTO {

    private Long id;

    private EmployeeDTO employee;

    private CarDTO car;

    private OfficeDTO office;

    private Date fromDate;

    private Date toDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ReservationDTO other = (ReservationDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.car, other.car)) {
            return false;
        }
        if (!Objects.equals(this.office, other.office)) {
            return false;
        }
        if (!Objects.equals(this.fromDate, other.fromDate)) {
            return false;
        }
        if (!Objects.equals(this.toDate, other.toDate)) {
            return false;
        }
        return true;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public OfficeDTO getOffice() {
        return office;
    }

    public void setOffice(OfficeDTO office) {
        this.office = office;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
