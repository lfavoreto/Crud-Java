package com.trab.model;

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
}