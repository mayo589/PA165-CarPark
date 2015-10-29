/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fi.muni.carparkapp;

import com.fi.muni.carparkapp.dao.CarDao;
import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.dao.OfficeDao;
import com.fi.muni.carparkapp.dao.ReservationDao;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author marek
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan(basePackageClasses = {CarDao.class, EmployeeDao.class, ReservationDao.class, OfficeDao.class})
public class JpaTestContext {
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(ds());
        lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return lcemfb;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public DataSource ds() {
        EmbeddedDatabaseBuilder edbBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = edbBuilder.setType(EmbeddedDatabaseType.DERBY).build();
        return db;
    }
    
}
