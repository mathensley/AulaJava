package br.unipe.cc.banco;

public class Conta {
	private float saldo;
	private int numConta;
	
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	
	public void debitar(float valor){
		if(valor > 0 && valor <= this.saldo){
			this.saldo -= valor;
		}
		else{
			System.out.println("Valor incorreto!");
		}
	}
	
	public void creditar(float valor){
		this.saldo += valor;
	}
	
}
