package com.trab.model;

public class Conteiner {
	private int id;
	private String nome;
	private String nmconteiner;
	private int tipo;
	private String status;
	private String categoria;
	
	public Conteiner(int id, String nome, String nmconteiner, int tipo, String status, String categoria) {
		this.id = id;
		this.nome = nome;
		this.nmconteiner = nmconteiner;
		this.tipo = tipo;
		this.status = status;
		this.categoria = categoria;
	}
	
	public Conteiner() {}
	
	public Conteiner(String nome, String nmconteiner, int tipo, String status, String categoria) {
		this.nome = nome;
		this.nmconteiner = nmconteiner;
		this.tipo = tipo;
		this.status = status;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getNmconteiner() {
		return nmconteiner;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNmconteiner(String nmconteiner) {
		this.nmconteiner = nmconteiner;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}