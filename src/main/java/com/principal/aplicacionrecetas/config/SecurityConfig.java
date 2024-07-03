package com.principal.aplicacionrecetas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity

                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> { 
                    String[] rutas = { "/rol/**","/comida/**" , "/usuario/**", "/categoria/**", "/tipo/**", "/comida/**" };
                    for (String ruta : rutas) {
                        // http.requestMatchers(HttpMethod.GET, ruta).permitAll();
                        // http.requestMatchers(HttpMethod.POST, ruta).permitAll();
                        // http.requestMatchers(HttpMethod.PUT, ruta).permitAll();
                        // http.requestMatchers(HttpMethod.DELETE, ruta).permitAll();


                        http.requestMatchers(HttpMethod.GET, ruta).hasAnyRole("ADMINISTRADOR");
                        http.requestMatchers(HttpMethod.POST, ruta).hasAnyRole("ADMINISTRADOR");
                        http.requestMatchers(HttpMethod.PUT, ruta).hasAnyRole("ADMINISTRADOR");
                        http.requestMatchers(HttpMethod.DELETE, ruta).hasAnyRole("ADMINISTRADOR");
                    }
              
                    http.requestMatchers("/registrar" ,"/login","/css/**", "/js/**", "/images/**", "/uploads/**", "/bootstrap/**","/fontawesome/**").permitAll();
                    
                    // Permitir el acceso a la página de inicio y el registro
                    http.requestMatchers("/comida/**").permitAll();
                    http.requestMatchers("/admin").hasRole("ADMINISTRADOR");
                    http.requestMatchers("/admin/**").hasRole("ADMINISTRADOR");
                    http.requestMatchers("/home").authenticated();
                    http.requestMatchers("/home/**").authenticated();
                })
                
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())

                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsServiceImpl) {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsServiceImpl);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
