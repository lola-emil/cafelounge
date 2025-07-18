package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
