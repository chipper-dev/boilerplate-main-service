package com.mitrais.chipper.temankondangan.backend.mainservice.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mitrais.chipper.temankondangan.backend.mainservice.config.JwtConfig;
import com.mitrais.chipper.temankondangan.backend.mainservice.controller.internal.LegacyFeignClient;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final JwtConfig jwtConfig;
    private final LegacyFeignClient legacyFeignClient;
    private final TokenProvider tokenProvider;

    public TokenAuthenticationFilter(JwtConfig jwtConfig, LegacyFeignClient legacyFeignClient, TokenProvider tokenProvider) {
        this.jwtConfig = jwtConfig;
        this.legacyFeignClient = legacyFeignClient;
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader(jwtConfig.getHeader());

        if(header == null || !header.startsWith(jwtConfig.getPrefix())) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace(jwtConfig.getPrefix(), "");

        try {
            Long userId = tokenProvider.getUserIdFromToken(token);
            if(userId != null) {
                Date logoutTime = legacyFeignClient.fetchUserbyId(header, userId).orElseThrow(() -> new NoSuchElementException("User not found")).getLogout();
                if (tokenProvider.validateToken(token, logoutTime)) {

                    List<GrantedAuthority> authorities = Collections.
                            singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            userId, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }

        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }
}
