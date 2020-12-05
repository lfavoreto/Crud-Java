package com.trab.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
	@Autowired
	MovimentacaoDAO mdao;
	
	public void insert(Movimentacao mov) {
		mdao.insert(mov);
	}
	
	public Map<String, Object> getMovimentacao(int id){
		return mdao.getMovimentacao(id);
	}

	public List<Map<String, Object>> getMovimentacoes() {
		return mdao.getMovimentacoes();
	}
}
