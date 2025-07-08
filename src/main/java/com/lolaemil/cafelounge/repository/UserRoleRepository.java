package com.lolaemil.cafelounge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolaemil.cafelounge.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    
}
