/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.configs;

import com.pat.formatter.EmployeeFormatter;
import com.pat.formatter.MedicalFormFormatter;
import com.pat.formatter.MedicineFormatter;
import com.pat.formatter.PatientFormatter;
import com.pat.formatter.PrescriptionFormatter;
import com.pat.vadilator.PassValidator;
import com.pat.vadilator.WebValidator;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Admin
 */
@Configuration
@ComponentScan(basePackages = {
    "com.pat"
})
@EnableTransactionManagement
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/resources/images/");
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");

        return source;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MedicineFormatter());
        registry.addFormatter(new PatientFormatter());
        registry.addFormatter(new EmployeeFormatter());
        registry.addFormatter(new MedicalFormFormatter());
        registry.addFormatter(new PrescriptionFormatter());
    }
    
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f;
    }
    
    @Bean
    public WebValidator userValidator() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new PassValidator());

        WebValidator validator = new WebValidator();
        validator.setSpringValidators(springValidators);

        return validator;
    }
    
//    @Bean
//    public WebValidator medicineValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new MedicineValidator());
//        
//        WebValidator validator = new WebValidator();
//        validator.setSpringValidators(springValidators);
//
//        return validator;
//    }
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver 
//                = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//
//        return resolver;
//    }
    
}
