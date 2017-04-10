package exercicios1602;

/*
 * Exercicio 4
 */

public class Media {
	
	float media;
	
	/*
	 * Metodo usado para calcular a media com base
	 * nas tres notas informadas pelo usuario, e
	 * informar se o mesmo foi aprovado, reprovado
	 * ou esta em recuperacao
	 */
	public void notas(float nota1, float nota2, float nota3){
		
		media = (nota1 + nota2 + nota3) / 3;
		
		System.out.println("Sua media eh: " + media);
		
		if(media >= 7){
			System.out.println("Voce foi aprovado!");
		}
		else if(media >=5 && media <= 7){
			System.out.println("Voce esta em recuperacao!");
		}
		else if(media < 5){
			System.out.println("Voce foi reprovado!");
		}
	}
}
