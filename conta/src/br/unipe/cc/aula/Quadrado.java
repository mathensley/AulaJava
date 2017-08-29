package br.unipe.cc.aula;

public class Quadrado extends Retangulo{
	private double lado;

	
	public Quadrado(double lado) {
		super(lado, lado);
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
}
