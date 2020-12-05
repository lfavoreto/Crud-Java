package com.trab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
	@Autowired
	MovimentacaoDAO mdao;
	
	public void insert(Movimentacao mov) {
		mdao.insert(mov);
	}
	
	
}
