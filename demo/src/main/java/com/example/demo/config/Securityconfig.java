package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.authentication.AuthenticationProviderBeanDefinitionParser;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {

    @Autowired
    UserDetailsService myuserDetailsService;


    @Bean
    public SecurityFilterChain securitychain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(Request ->Request.
                        requestMatchers("/csrf","/Register","/login").permitAll()
                        .anyRequest().authenticated())
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//     public UserDetailsService userdetails(){
//        UserDetails user01 = User.withUsername("sharana")
//                .password("{noop}password").roles("admin").build();
//        UserDetails user02 = User.withUsername("raj")
//                .password("{noop}raj").roles("employ").build();
//
//        return new InMemoryUserDetailsManager(user01,user02);
//
//    }

//    since we are creating our own authenticate provider
//    1 . create provider using DaoAuthenticateProvider
//    2.add setpasswordEncoder
//    3.add setUserDetailsService - > we need to create our own  service we need to create a class that implements UserDetailsservice
//    4  userdetailservice has one obstract method  getUserByUserName which retrun object of type UserDetails
//    5 since userDetail is interface we need to create a class that implements UserDetails





    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
         provider.setPasswordEncoder(bCryptPasswordEncoder());

        provider.setUserDetailsService(myuserDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {

        System.out.println("i am going through this class");
        return config.getAuthenticationManager();
    }
}
