package com.example.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // EnableWebSecurity habilita a personalização de configuração de segurança

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {


        httpSecurity.csrf(customizer -> customizer.disable());
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults()); // habilita Basic Authentication

        return httpSecurity.build();
    }

//    @Bean
//   public UserDetailsService userDetailsService() {
//
//        UserDetails userOne = User
//                .withDefaultPasswordEncoder()
//                .username("gabriel")
//                .password("g@123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails userTwo = User
//                .withDefaultPasswordEncoder()
//                .username("maria")
//                .password("m@123")
//                .roles("USER")
//                .build();
//
//        // environment dev
//        return new InMemoryUserDetailsManager(userOne, userTwo);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

    /* Ao configura as credenciais via .properties o Spring utiliza a implementação InMemoryDetailsManager
    * por padrão para armazenar na memoria. Para integrações com banco de dados é necessário implementar UserDetailsService
    *  */

}
