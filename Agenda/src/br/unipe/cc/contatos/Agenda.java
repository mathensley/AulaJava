package br.unipe.cc.contatos;

import java.util.Arrays;

public class Agenda {
	Contato contatos[];
	private int qnt;
	
	public Agenda(int tam) {
		contatos = new Contato[tam];
	}
	
	public boolean inserir(Contato c){
		Arrays.sort(contatos);
		
		if(Arrays.binarySearch(contatos, c) > 0)
			return false;
		if(contatos.length == qnt)
			return false;
		
		contatos[qnt++] = c;
		return true;
	}

	public Contato buscarNome(String nome){
		
		for(Contato c : contatos){
			if(c.getNome().equals(nome))
				return c;
		}
		return null;
		
	}
}
