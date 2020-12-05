package com.trab.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConteinerService {
	@Autowired
	ConteinerDAO cdao;
	
	public void insert(Conteiner cont) {
		cdao.insert(cont);
	}
	
	public Map<String, Object> getConteiner(int id){
		return cdao.getConteiner(id);
	}

	public List<Map<String, Object>> getConteiners() {
		return cdao.getConteiners();
	}
}