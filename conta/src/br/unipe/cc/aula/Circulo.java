package br.unipe.cc.aula;

public class Circulo extends Forma {
	public static final double PI = 3.14;
	private double raio;
	
	
	public Circulo(double raio) {
		this.raio = raio;
	}

	protected double area() {
		return PI * (raio * raio);
	}

}
