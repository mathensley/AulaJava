package vendas;

public class Vendedor {
	private String nome;
	private String codigo;
	private String endereco;
	private float comissao;
	private static final int porceComissao = 10;
	
	public Vendedor(String nome, String codigo, String endereco) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public static int getPorcecomissao() {
		return porceComissao;
	}

	
		
}
