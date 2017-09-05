package br.unipe.cc.personagens;

import java.util.Random;

import br.unipe.cc.armas.Arma;

public abstract class Personagem {
	private Arma arma;
	
	public abstract void desenho();
	
	public void falar(){
		int selec;
		Random random = new Random();
		
		selec = random.nextInt(3);
		
		if(selec == 0)
			System.out.println("Roger that!");
		else if(selec == 1)
			System.out.println("Fire in the hoooole!");
		else if(selec > 1)
			System.out.println("The bomb has been planted...");
	}
	
	public void setArma(Arma a){
		 this.arma = a;
	}
	
	public void usar(){
		arma.atirar();
	}
}
