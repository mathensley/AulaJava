package vendas;

public class Vendas {
	private Produto produto;
	private Vendedor vendedor;
	private float desconto;
	private float valor = 1;
	float valorDesconto;
	private int qntItens;
	
	
	public void efetuarDesconto(float desconto) {
		valorDesconto = produto.getValorVenda() - ((produto.getValorVenda() * desconto) / 100);
		produto.setValorVenda(valorDesconto);
	}
	
	public void calcularValor(int qntItens) {
		valor = qntItens * produto.getValorVenda();
	}
	
	public void calcularComissao(float valor) {
		if(produto.isPromocao())
			vendedor.setComissao(((valor * vendedor.getPorcecomissao()) / 100) / 2);
		else
			vendedor.setComissao((valor * vendedor.getPorcecomissao()) / 100);
	}
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getQntItens() {
		return qntItens;
	}
	public void setQntItens(int qntItens) {
		this.qntItens = qntItens;
	}
	
	

}
