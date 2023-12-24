package br.com.pilares.ancontabil.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.pilares.ancontabil.menu.model.dto.MenuDTO;

@Service
public class MenuService {

	public Set<MenuDTO> getMenu(){
		return new MenuDTO().listar();
	}	
	
}