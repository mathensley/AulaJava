package br.unipe.cc.banco;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private float saldo;
	private int numConta;
	List<Lancamento> lanca = new ArrayList<Lancamento>();
	
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
			lanca.add(new Lancamento("D", valor));
		}
		else{
			System.out.println("Valor incorreto!");
		}
	}
	
	public void creditar(float valor){
		this.saldo += valor;
		lanca.add(new Lancamento("C", valor));
	}
	
}
