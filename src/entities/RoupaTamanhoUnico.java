package entities;

public class RoupaTamanhoUnico extends Peca implements Item {

	public RoupaTamanhoUnico(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
		super(descricao, quantidade, estoqueMinimo, estoqueMaximo);

	}
	
	@Override
	public void reposicaoEstoque() {
		if (getQuantidade() <= getEstoqueMinimo()) {
			setQuantidade(getEstoqueMaximo());
		}

	}

	@Override
	public void venda() {
		if (getQuantidade() == getEstoqueMinimo()) 
			throw new IllegalArgumentException("Não temos a quantidade escolhida no estoque");
		setQuantidade(getQuantidade() - 1);
		

	}

	
}
