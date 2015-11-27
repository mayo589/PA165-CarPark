/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp.exceptions;

import org.springframework.dao.DataAccessException;

/**
 *
 * @author MareK Mihalech 410083
 */
public class SimpleDataAccessException  extends DataAccessException {
    
    public SimpleDataAccessException(String msg) {
        super("Exception on Persistance layer! " + msg);
    }
    
    public SimpleDataAccessException(Throwable cause) {
        super("Exception on Persistance layer!", cause);
    }
    
    public SimpleDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
