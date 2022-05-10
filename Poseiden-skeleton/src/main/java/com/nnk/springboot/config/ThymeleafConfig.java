package com.nnk.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author tamorieeeen
 *
 */
@Configuration
public class ThymeleafConfig {

    @Bean
    public CustomDialect customDialect() {

        return new CustomDialect();
    }
}