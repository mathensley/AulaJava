package br.unipe.cc.banco;

import java.util.Date;

public class Lancamento {
	Date data;
	private double valor;
	private String tipo;
	
	public Lancamento(){
		data = new Date();
	}
	public Lancamento(String tipos, double valor){
		data = new Date();
		this.setTipo(tipos);
		this.setValor(valor);
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
