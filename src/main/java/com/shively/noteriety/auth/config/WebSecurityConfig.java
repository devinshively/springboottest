package com.shively.noteriety.auth.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * User: devinshively
 * Created On: 9/23/14 11:25 PM
 */
//@Configuration
//@EnableWebSecurity
//@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/sign-up").permitAll()
//                .antMatchers("/sign-in").permitAll()
//                .antMatchers("/authenticate").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/")
//                .loginProcessingUrl("/loginprocess")
//                .failureUrl("/mobile/app/sign-in?loginFailure=true")
//                .permitAll();
//    }
}
