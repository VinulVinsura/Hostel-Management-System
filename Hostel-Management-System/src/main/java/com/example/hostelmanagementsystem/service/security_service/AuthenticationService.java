package com.example.hostelmanagementsystem.service.security_service;

import com.example.hostelmanagementsystem.repository.ProspectiveStudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final ProspectiveStudentRepo prospectiveStudentRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return prospectiveStudentRepo.findByEmail(username);
    }
}
