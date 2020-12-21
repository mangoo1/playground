package com.dvncs.playground.springsecurity.config;

import com.dvncs.playground.springsecurity.handler.FailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Web security class
 */
@Configuration
//@EnableWebSecurity could be ignored as it's in WebSecurityEnablerConfiguration.java
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("deven")
            .password(passwordEncoder().encode("123456"))
            .authorities("admin")
        .and()
            .withUser("doreen")
            .password(passwordEncoder().encode("112233"))
            .authorities("user");
    }

    // Login page generation: DefaultLoginPageGeneratingFilter
    // you can override it by configurating httpSecurity
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/showLogin") //in resources/static
            .loginProcessingUrl("/user/login") //the action defined in the page
            .defaultSuccessUrl("/showMain")
            //two ways to configurate this, the url path or the haneler
//            .failureForwardUrl("/showError")
            .failureHandler(new FailureHandler("/error.html"))
        ;

        //Authorization
        http.authorizeRequests()
            //no need to authenticate
            .antMatchers( "/showLogin","/user/login","/error.html").permitAll()
            //need authenticate for all other requests
            .anyRequest().authenticated();
        //Need to disable it if you don't config csrf
        //In parameter or header
//        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
