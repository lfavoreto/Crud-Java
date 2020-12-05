package com.trab.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovimentacaoDAO{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insert(Movimentacao mov){
		String sql = "INSERT INTO Movimentacao" + "(nm_Navio, ds_Movimentacao, dt_Inicio, dt_Final) VALUES (?,?,?,?)";
		jdbc.update(sql, new Object[] {
				mov.getNavio(),
				mov.getMovimentacao(),
				mov.getDataInicio(),
				mov.getDataFim(),
		});
	}
};