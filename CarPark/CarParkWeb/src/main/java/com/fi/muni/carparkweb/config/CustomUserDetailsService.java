package com.fi.muni.carparkweb.config;

import com.fi.muni.carparkapp.dto.EmployeeDTO;
import com.fi.muni.carparkapp.facade.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Hellar
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeFacade employeeFacade;
    
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        EmployeeDTO employee = employeeFacade.findEmployeeByName(name);
        if (employee == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(
                employee.getLastName(), employee.getPasswordHash(), true, true,
                true, true, getGrantedAuthorities(employee));
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(EmployeeDTO employee) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        if (employeeFacade.isAdmin(employee)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        
        return authorities;
    }
    
}
