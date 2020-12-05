package com.trab.model;

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
}