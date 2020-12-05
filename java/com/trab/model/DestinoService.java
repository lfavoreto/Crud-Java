package com.trab.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {
	@Autowired
	DestinoDAO ddao;
	
	public void insert(Destino dest) {
		ddao.insert(dest);
	}
	
	public Map<String, Object> getDestino(int id){
		return ddao.getDestino(id);
	}

	public List<Map<String, Object>> getDestinos() {
		return ddao.getDestinos();
	}
}