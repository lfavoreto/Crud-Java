package com.trab.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConteinerDAO{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insert(Conteiner cont){
		String sql = "INSERT INTO Conteiner" + "(nm_Cliente, cd_Conteiner, ic_Tipo, ic_Status, ic_Categoria) VALUES (?,?,?,?,?)";
		jdbc.update(sql, new Object[] {
				cont.getNome(),
				cont.getNmconteiner(),
				cont.getTipo(),
				cont.getStatus(),
				cont.getCategoria()
		});
	}
	
	public Map<String, Object> getConteiner(int id){
		String sql = "SELECT * FROM conteiner WHERE conteiner.id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	public List<Map<String, Object>> getConteiners(){
		String sql = "SELECT * FROM Conteiner";
		List<Map<String, Object>> conteiners = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return conteiners;
	}
}