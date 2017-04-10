package seguradora;

public class PessoaJ extends Cliente{
	private String cnpj;
	
	public PessoaJ(String cpf, String rg, String nome, String tel, String cnpj) {
		super(cpf, rg, nome, tel);
		this.cnpj = cnpj;
		// TODO Auto-generated constructor stub
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String toString() {
		return "" + this.getNome() + "\n" + this.getCpf() + "\n" + this.getRg() + "\n" + this.getCnpj() + "\n" + this.getTel();
	}
}
