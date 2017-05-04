package com.aws.codestar.projecttemplates.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
@ComponentScan("com.aws.codestar.projecttemplates")
public class VehicleConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public MappingJackson2HttpMessageConverter vehicleConverter() {
        return new MappingJackson2HttpMessageConverter(
                Jackson2ObjectMapperBuilder
                        .json()
                        .build()
                        .enable(SerializationFeature.WRAP_ROOT_VALUE)
                        .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
        );
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(vehicleConverter());
        super.addDefaultHttpMessageConverters(converters);
    }
}
