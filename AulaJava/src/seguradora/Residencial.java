package seguradora;

public class Residencial extends Contrato{
	private String end;
	private String zona;
	private String residencia;

	
	
	public Residencial(float valorImovel, String nome, double seguro, String end, String zona, String residencia) {
		super(valorImovel, nome, seguro);
		this.end = end;
		this.zona = zona;
		this.residencia = residencia;
		// TODO Auto-generated constructor stub
	}

	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getResidencia() {
		return residencia;
	}


	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	
	public String toString() {
		return "" + this.getNome() +"\n" + this.getValorImovel() +"\n" + this.getEnd() + "\n" + this.getZona() + "\n" + this.getResidencia() + "\nSEGURO: " + this.getSeguro() + " Reais";
	}
	
}
