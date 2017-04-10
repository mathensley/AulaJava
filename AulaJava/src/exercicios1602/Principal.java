package exercicios1602;
import java.util.Scanner;

/*
 * Executar exercicios
 */

public class Principal {

	public static void main(String[] args) {
		
		float num1 = 4, num2 = 3, nota1, nota2, nota3;
		String name = "";
		int ida = 0, ano1, ano2;
		
		Scanner ler = new Scanner(System.in);
		Soma numero = new Soma();
		NomeIdade nome = new NomeIdade(); 
		NomeIdade idade = new NomeIdade();
		Idade an = new Idade();
		Media nota = new Media();
		
		/*
		 * exercicio 1
		 */
		System.out.println(numero.somar(num1, num2));
		
		/*
		 * exercicio 2
		 */
		nome.nome(name);
		idade.idade(ida);
		
		/*
		 * exercicio 3
		 */
		System.out.println("Digite o ano que voce nasceu:");
		ano1 = ler.nextInt();
		System.out.println("Digite o ano atual:");
		ano2 = ler.nextInt();
		System.out.println("Esse ano voce faz " + an.ano(ano1, ano2) + " anos");
		
		/*
		 * exercicio 4
		 */
		System.out.println("Digite sua primeira nota:");
		nota1 = ler.nextFloat();
		System.out.println("Digite sua segunda nota:");
		nota2 = ler.nextFloat();
		System.out.println("Digite sua terceira nota:");
		nota3 = ler.nextFloat();
		nota.notas(nota1, nota2, nota3);
		
		ler.close();
		
	}

}
