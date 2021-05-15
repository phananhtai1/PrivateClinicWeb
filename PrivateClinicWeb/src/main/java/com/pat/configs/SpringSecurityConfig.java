/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = "com.pat")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/admin/login")
                .usernameParameter("username")
                .passwordParameter("password");

        http.formLogin().defaultSuccessUrl("/admin/")
                .failureUrl("/admin/login?error");

        http.logout().logoutSuccessUrl("/admin/login");

        http.exceptionHandling()
                .accessDeniedPage("/admin/login?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/**/admin").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/patient").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/employee").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/medicine").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/medicalForm").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/admin/appointment").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/prescription").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/bill").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/addPatient").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/**/addMedi").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/**/billStats").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/**/patientStats").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        http.csrf().disable();

    }

}
