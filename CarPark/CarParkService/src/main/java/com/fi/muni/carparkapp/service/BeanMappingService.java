package com.fi.muni.carparkapp.service;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;


public interface BeanMappingService {
    
    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);
    public <T> T mapTo(Object u, Class<T> mapToClass);
    public Mapper getMapper();
    
}
