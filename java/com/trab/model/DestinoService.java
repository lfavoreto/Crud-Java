package com.trab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {
	@Autowired
	DestinoDAO ddao;
	
	public void insert(Destino dest) {
		ddao.insert(dest);
	}
}