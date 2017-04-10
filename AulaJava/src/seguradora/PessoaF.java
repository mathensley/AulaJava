package seguradora;

public class PessoaF extends Cliente{
	private String cnh;
	
	public PessoaF(String cpf, String rg, String nome, String tel, String cnh) {
		super(cpf, rg, nome, tel);
		this.cnh = cnh;
		// TODO Auto-generated constructor stub
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String toString() {
		return "" + this.getNome() + "\n" + this.getCpf() + "\n" + this.getRg() + "\n" + this.getCnh() + "\n" + this.getTel();
	}
}
