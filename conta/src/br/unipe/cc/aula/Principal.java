package br.unipe.cc.aula;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Forma> formas = new ArrayList<Forma>();
		Forma maior;
		
		formas.add(new Retangulo(9, 3));
		formas.add(new Retangulo(5, 2));
		formas.add(new Triangulo(3, 2));
		formas.add(new Quadrado(5));
		formas.add(new Quadrado(8));
		formas.add(new Circulo(4));
		
		maior = CalculaForma.calculo(formas);
		
		System.out.println(maior.area());
	}

}
