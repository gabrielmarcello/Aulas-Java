package br.com.fiap.spring.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(
                authorizationRequests ->
                        authorizationRequests
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/livros/lista").permitAll()
                                .anyRequest().authenticated()
        ).oauth2Login(
                oauth -> oauth.defaultSuccessUrl("/livros/lista"))
                .formLogin(Customizer.withDefaults())
                        .build();
    }
}
