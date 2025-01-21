package com.moonlandinghotel.moon_landing_hotelweb.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        // Si el token existe y empieza con "Bearer "
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // Eliminar el prefijo "Bearer "

            // Extraer el nombre de usuario del token
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, null);
                // Establecer la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        // Pasar al siguiente filtro en la cadena
        filterChain.doFilter(request, response);
    }
}