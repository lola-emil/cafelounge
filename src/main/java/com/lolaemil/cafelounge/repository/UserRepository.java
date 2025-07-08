package com.lolaemil.cafelounge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolaemil.cafelounge.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
