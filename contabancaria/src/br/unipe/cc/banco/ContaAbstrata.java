package br.unipe.cc.banco;

public abstract class ContaAbstrata {
	float saldo;
	private int numConta;
	
	public abstract void debitar(float valor);
	public abstract void creditar(float valor);
	
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
}
