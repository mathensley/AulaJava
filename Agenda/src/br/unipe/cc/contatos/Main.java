package br.unipe.cc.contatos;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Object a = new Contato("Matheus", "9965193", new Date());
		Object b = new Contato("Luis", "12321312", new Date());
		Object c = new Contato("Raissa", "43422234", new Date());
		
		Agenda agenda = new Agenda(5);
		
		System.out.println(agenda.inserir((Contato) a));
		System.out.println(agenda.inserir((Contato) b));
		System.out.println(agenda.inserir((Contato) c));
	}

}
