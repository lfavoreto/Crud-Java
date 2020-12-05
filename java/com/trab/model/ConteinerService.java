package com.trab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConteinerService {
	@Autowired
	ConteinerDAO cdao;
	
	public void insert(Conteiner cont) {
		cdao.insert(cont);
	}
}