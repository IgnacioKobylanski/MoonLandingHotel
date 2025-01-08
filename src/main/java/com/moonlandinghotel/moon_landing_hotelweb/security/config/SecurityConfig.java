package com.moonlandinghotel.moon_landing_hotelweb.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**"))  // Desactiva CSRF para las rutas de la API
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/public/**", "/login").permitAll()  // Rutas públicas permitidas
                                .requestMatchers("/api/**").permitAll()  // Permitir acceso sin autenticación a la API
                                .anyRequest().authenticated()  // Todas las demás rutas requieren autenticación
                )
                .formLogin(Customizer.withDefaults());  // Usa el formulario de login predeterminado de Spring Security

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt para codificar las contraseñas de los usuarios(revisar mas tarde si es lo optimo)
    }
}
