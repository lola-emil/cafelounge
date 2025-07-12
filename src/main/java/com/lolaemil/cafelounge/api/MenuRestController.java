package com.lolaemil.cafelounge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lolaemil.cafelounge.dto.MenuDTO;
import com.lolaemil.cafelounge.model.Menu;
import com.lolaemil.cafelounge.repository.MenuRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/menus")
public class MenuRestController {

    @Autowired
    MenuRepository menuRepository;
    
    @PostMapping
    ResponseEntity<Menu> addMenu(@Valid @RequestBody MenuDTO menuBody) {
        Menu menu = new Menu();

        menu.setName(menuBody.getName());
        menu.setDescription(menuBody.getDescription());

        Menu newMenu = menuRepository.save(menu);

        return ResponseEntity.status(200).body(newMenu);
    }    
}
