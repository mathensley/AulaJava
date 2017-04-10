package seguradora;

public class Contrato {
	private float valorImovel;
	private double seguro;
	private String nome;
	
	public Contrato(float valorImovel, String nome, double seguro) {
		super();
		this.valorImovel = valorImovel;
		this.nome = nome;
		this.seguro = seguro;
	}
	
	public float getValorImovel() {
		return valorImovel;
	}
	public void setValorImovel(float valorImovel) {
		this.valorImovel = valorImovel;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSeguro() {
		return seguro;
	}
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}
}
