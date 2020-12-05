package com.trab.model;

public class Movimentacao {
	private int id;
	private String Navio;
	private String Movimentacao;
	private String DataInicio;
	private String DataFim;
	
	public Movimentacao() {}
	
	public Movimentacao(String navio, String movimentacao, String dataInicio, String dataFim) {
		Navio = navio;
		Movimentacao = movimentacao;
		DataInicio = dataInicio;
		DataFim = dataFim;
	}	
	
	public Movimentacao(int id, String navio, String movimentacao, String dataInicio, String dataFim) {
		this.id = id;
		Navio = navio;
		Movimentacao = movimentacao;
		DataInicio = dataInicio;
		DataFim = dataFim;
	}

	public String getNavio() {
		return Navio;
	}

	public void setNavio(String navio) {
		this.Navio = navio;
	}

	public String getMovimentacao() {
		return Movimentacao;
	}

	public void setMovimentacao(String movimentacao) {
		this.Movimentacao = movimentacao;
	}

	public String getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.DataInicio = dataInicio;
	}

	public String getDataFim() {
		return DataFim;
	}

	public void setDataFim(String dataFim) {
		this.DataFim = dataFim;
	}

	public int getId() {
		return id;
	}
}
