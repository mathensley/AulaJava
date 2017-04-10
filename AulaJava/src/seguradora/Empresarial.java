package seguradora;

public class Empresarial extends Contrato{
	private int num;
	private int visitas;
	private String ramo;
	
	public Empresarial(float valorImovel, String nome, double seguro, int num, int visitas, String ramo) {
		super(valorImovel, nome, seguro);
		this.num = num;
		this.visitas  = visitas;
		this.ramo = ramo;
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	
	public String toString() {
		return "" + this.getNome() +"\n" + this.getValorImovel() +"\n" + this.getNum() + "\n" + this.getVisitas() + "\n" + this.getRamo() + "\nSEGURO: " + this.getSeguro() + " Reais";
	}
}
