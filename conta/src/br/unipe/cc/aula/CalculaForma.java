package br.unipe.cc.aula;

import java.util.List;

public class CalculaForma {
	
	public static Forma calculo(List<Forma> formas){
		Forma teste;
		teste = formas.get(0);
				
		for(Forma i : formas){
			if(i.area() > teste.area()){
				teste = i;
			}
		}
		return teste;
	}
}
