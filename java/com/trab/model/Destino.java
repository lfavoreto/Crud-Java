package com.trab.model;

public class Destino {
	private int id;
	private String carga;
	private String bandeira;
	private String origem;
	private String destino;
	
	public Destino(int id, String carga, String bandeira, String origem, String destino) {
		this.id = id;
		this.carga = carga;
		this.bandeira = bandeira;
		this.origem = origem;
		this.destino = destino;
	}

	public Destino() {}

	public Destino(String carga, String bandeira, String origem, String destino) {
		this.carga = carga;
		this.bandeira = bandeira;
		this.origem = origem;
		this.destino = destino;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getId() {
		return id;
	}
	
}