package com.fi.muni.sampledata;

import com.fi.muni.carparkapp.service.config.ServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Jan Hellar
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = {SampleDataLoadingFacade.class})
public class SampleDataConfiguration {
    
    SampleDataLoadingFacade sampleDataLoadingFacade;
    
    public void dataLoading() {
        sampleDataLoadingFacade.loadData();
    }
}
