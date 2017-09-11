package br.unipe.cc.jogo;

import br.unipe.cc.armas.*;
import br.unipe.cc.personagens.*;

public class UsaPersonagem {

	public static void main(String[] args) {
		
		Personagem p = new Terrorists();
		
		p.desenho();
		p.setArma(new Ak47());
		p.usar();
		p.falar();
		p.setArma(new Bomba());
		p.usar();
		
		p = new CounterTerrorists();
		p.desenho();
		p.setArma(new M4A1());
		p.usar();
		p.falar();
		p.setArma(new Faca());
		p.usar();
		
		p = new Mago();
		p.setArma(new Magia());
		p.desenho();
		p.usar();
		p.falar();
		p.correr();
		p.setArma(new Desarmado());
		p.usar();
		
		p = new DragaoAlado();
		p.setArma(new Magia());
		p.desenho();
		p.usar();
		p.falar();
		p.correr();
	}
}
