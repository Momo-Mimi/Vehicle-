/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.schoolmanagememt.Students;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
/*
 *
 * @author motho
 */
@Configuration
@EnableWebSecurity
public class SercurityCon 
{
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/students/**").authenticated()
            .anyRequest().permitAll())
            .httpBasic(httpBasic -> {});
        return http.build();

   }
 
    @Bean
    public InMemoryUserDetailsManager userDetailsService() 
    {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Students")
                .password("Mothomi@2007")
                .roles("ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(user);

    }
 
}
