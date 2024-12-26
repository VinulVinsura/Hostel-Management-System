package com.example.hostelmanagementsystem.config;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.service.security_service.AuthenticationService;
import com.example.hostelmanagementsystem.service.security_service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nullable;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(@Nullable HttpServletRequest request,
                                    @Nullable HttpServletResponse response,
                                    @Nullable FilterChain filterChain) throws ServletException, IOException {


        String authHeader = request.getHeader("Authorization");


        if (authHeader ==null || !authHeader.startsWith("Bearer ")){

            //        request.getServletPath().equals("/api/user/save-user")
            if(request.getServletPath().equals("/api/student/login")||
                    request.getServletPath().equals("/api/student/save-prospective-student") ||
                    request.getServletPath().equals("/api/main/login")){
                filterChain.doFilter(request,response);
                return;
            }


            ResponseDto responseDto=new ResponseDto(3,"Not a Authorized");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            ObjectMapper mapper=new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(responseDto));

            return;

        }

        String token = authHeader.substring(7);
        String userName = jwtService.extractUserName(token);
        if (userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = authenticationService.loadUserByUsername(userName);
            if (jwtService.isValid(token,userDetails)){
                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request,response);



    }
}
