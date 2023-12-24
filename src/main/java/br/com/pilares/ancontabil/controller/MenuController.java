package br.com.pilares.ancontabil.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.ancontabil.menu.model.dto.MenuDTO;
import br.com.pilares.ancontabil.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
    private MenuService menuService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<MenuDTO>> getDadosMenu() {
    	return	new ResponseEntity<>(this.menuService.getMenu(), HttpStatus.OK);
    }

	
}
