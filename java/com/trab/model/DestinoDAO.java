package com.trab.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DestinoDAO{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insert(Destino dest){
		String sql = "INSERT INTO Destino" + "(nm_Carga, nm_Bandeira, ds_Origem, ds_Destino) VALUES (?,?,?,?)";
		jdbc.update(sql, new Object[] {
				dest.getCarga(),
				dest.getBandeira(),
				dest.getOrigem(),
				dest.getDestino()
		});
	}
	
	public Map<String, Object> getDestino(int id){
		String sql = "SELECT * FROM Destino WHERE Destino.id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	public List<Map<String, Object>> getDestinos(){
		String sql = "SELECT * FROM Destino";
		List<Map<String, Object>> destinos = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return destinos;
	}
}