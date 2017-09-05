package br.unipe.cc.aula;

public class Retangulo extends Forma{
	private double base;
	private double altura;

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	protected final double area() {
		return base * altura;
	}

	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

}