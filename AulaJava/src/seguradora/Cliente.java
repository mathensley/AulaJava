package seguradora;

public class Cliente {
	private String cpf;
	private String rg;
	private String nome;
	private String tel;
	
	
	public Cliente(String cpf, String rg, String nome, String tel) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.tel = tel;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
