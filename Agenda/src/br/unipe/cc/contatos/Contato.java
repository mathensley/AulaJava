package br.unipe.cc.contatos;

import java.util.Date;

public class Contato implements Comparable {
	private String nome;
	private String fone;
	private Date nascimento;

	public Contato(String nome, String fone, Date nascimento) {
		this.nome = nome;
		this.fone = fone;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public int compareTo(Object obj) {
		if(obj instanceof Contato){
			Contato i = (Contato) obj;
			return this.nome.compareTo(i.nome);
		}
		return -2;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Contato){
			Contato i = (Contato) obj;
			return this.nome.equals(i.getNome()) && this.nome.equals(i.getFone());
		}
		return false;
	}

}
