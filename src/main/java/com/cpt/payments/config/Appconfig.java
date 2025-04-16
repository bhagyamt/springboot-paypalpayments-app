package com.cpt.payments.config;

import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Configuration
public class Appconfig {

    /**
     * * ModelMapper bean for mapping between DTOs and entities.
     * @return
     */

     @Bean
     ModelMapper modelMapper() {
        return new ModelMapper();
        
    }

}
