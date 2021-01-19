package com.samuel.barbearia.repository;

import com.samuel.barbearia.domain.BarberUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarberUserRepository extends JpaRepository<BarberUser,Long> {
    BarberUser findByUsername(String username);
}
