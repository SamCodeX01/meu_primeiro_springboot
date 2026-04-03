package com.example.meu_primeiro_springboot.security;

import com.example.meu_primeiro_springboot.model.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
            if(authHeader == null || !authHeader.startsWith("Bearer")){
                filterChain.doFilter(request, response);
                return;
            }

            String token = authHeader.substring(7);
            String username = JwtUtil.extractUserName(token);

            if(username != null && SecurityContextHolder.getContext().getAuthentication == null){
                UserDetails userDatails = userDetailsService.loadUserByUserName(username);
                    if(JwtUtil.validateToken(token)){
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                    filterChain.doFilter(request,response);
            }

    }
}
