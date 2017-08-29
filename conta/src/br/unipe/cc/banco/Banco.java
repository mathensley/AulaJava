package br.unipe.cc.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Conta> contas = new ArrayList<>();

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void debitar(int numConta, float valor){
		for(Conta c : contas){
			if(c.getNumConta() == numConta){
				c.debitar(valor);
				return;
			}
		}
	}
	
	public void creditar(int numConta, float valor){
		for(Conta c: contas){
			if(c.getNumConta() == numConta){
				c.creditar(valor);
				return;
			}
		}
	}
}
