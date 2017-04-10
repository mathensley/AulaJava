package exercicios1602;
import java.util.Scanner;

/*
 * Exercicio 2
 */

public class NomeIdade {
	
	Scanner ler = new Scanner(System.in);
	/*
	 * Metodo usado para receber o nome em string
	 */
	public String nome(String name){
		System.out.println("Digite seu nome:");
		name = ler.nextLine();
		return name;
	}
	
	/*
	 * Metodo usado para receber a idade em inteiro
	 */
	public int idade(int ida){
		System.out.println("Digite sua idade:");
		ida = ler.nextInt();
		return ida;
	}
	
}
