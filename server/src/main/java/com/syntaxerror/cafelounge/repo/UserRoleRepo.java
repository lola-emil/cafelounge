package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long>{
    
}
