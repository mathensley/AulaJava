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
		
		p = new CounterTerrorists();
		p.desenho();
		p.setArma(new M4A1());
		p.usar();
		p.falar();
	}
}
