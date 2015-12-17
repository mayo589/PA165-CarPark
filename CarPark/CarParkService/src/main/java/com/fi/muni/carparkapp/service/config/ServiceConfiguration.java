package com.fi.muni.carparkapp.service.config;

import com.fi.muni.carparkapp.JpaTestContext;
import com.fi.muni.carparkapp.service.CarServiceImpl;
import com.fi.muni.carparkapp.service.EmployeeServiceImpl;
import com.fi.muni.carparkapp.service.OfficeServiceImpl;
import com.fi.muni.carparkapp.service.ReservationServiceImpl;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaTestContext.class)
@ComponentScan(basePackageClasses = {CarServiceImpl.class,  EmployeeServiceImpl.class, OfficeServiceImpl.class, ReservationServiceImpl.class})
public class ServiceConfiguration {
    
    @Bean
    public Mapper dozer() {
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerCustomConfig());
        return dozer;
    }
    
    public class DozerCustomConfig extends BeanMappingBuilder {
        @Override
        protected void configure() {
            
        }
    }
}
