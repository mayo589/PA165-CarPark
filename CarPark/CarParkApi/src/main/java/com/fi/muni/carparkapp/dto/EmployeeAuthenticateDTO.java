package com.fi.muni.carparkapp.dto;

/**
 *
 * @author Jan Hellar
 */
public class EmployeeAuthenticateDTO {
    
    private Long emloyeeId;
    private String password;

    public Long getEmployeeId() {
        return emloyeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setEmployeeId(Long emloyeeId) {
        this.emloyeeId = emloyeeId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
