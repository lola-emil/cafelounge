package com.lolaemil.cafelounge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolaemil.cafelounge.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    
}
