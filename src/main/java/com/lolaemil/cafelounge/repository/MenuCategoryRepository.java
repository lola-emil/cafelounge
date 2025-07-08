package com.lolaemil.cafelounge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolaemil.cafelounge.model.MenuCategory;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
    
}
