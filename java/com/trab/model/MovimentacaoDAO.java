package com.trab.model;

import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getMovimentacao(int id){
		String sql = "SELECT * FROM Movimentacao WHERE Movimentacao.id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	public List<Map<String, Object>> getMovimentacoes(){
		String sql = "SELECT * FROM Movimentacao";
		List<Map<String, Object>> movimentacoes = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return movimentacoes;
	}
	
	public void deleteMovimentacao(int id){
		String sql = "DELETE FROM Movimentacao WHERE id = ?";
		jdbc.update(sql, new Object[] {id});
	}
};