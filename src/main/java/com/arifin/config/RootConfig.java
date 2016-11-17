package com.arifin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by etos on 10/31/2016.
 */
@Configuration
@ComponentScan(basePackages={"com.arifin"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {
}
