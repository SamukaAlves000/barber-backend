package com.samuel.barbearia.service;

import com.samuel.barbearia.repository.BarberUserRepository;
import com.samuel.barbearia.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarberUserService implements UserDetailsService {

    private final BarberUserRepository barberUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        return Optional.ofNullable(barberUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
