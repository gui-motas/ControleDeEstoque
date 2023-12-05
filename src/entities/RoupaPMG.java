package entities;

import java.util.Scanner;

public class RoupaPMG implements Item {
	Scanner sc = new Scanner(System.in);
	protected String descricao;
	private int quantidadeP;
	private int quantidadeM;
	private int quantidadeG;
	private int estoqueMinimo, estoqueMaximo;

	public RoupaPMG(String descricao, int quantidadeP, int quantidadeM, int quantidadeG, int estoqueMinimo,
			int estoqueMaximo) {

		this.descricao = descricao;
		this.quantidadeP = quantidadeP;
		this.quantidadeM = quantidadeM;
		this.quantidadeG = quantidadeG;
		this.estoqueMinimo = estoqueMinimo;
		this.estoqueMaximo = estoqueMaximo;
	}

@Override
	public void venda() {
		System.out.println("Digite o tamanho da roupa:(P/M/G)");
		char tamanho = sc.next().charAt(0);
		
		if (!(Character.toUpperCase(tamanho) == 'P' || Character.toUpperCase(tamanho) == 'M'|| Character.toUpperCase(tamanho) == 'G')) {
			throw new IllegalArgumentException("Tamanho invalido");
		}
		switch (Character.toUpperCase(tamanho)) {

		case 'P':
			setQuantidadeP(getQuantidadeP() - 1) ;
			break;

		case 'M':
			setQuantidadeM(getQuantidadeM() - 1) ;
			break;

		case 'G':
			setQuantidadeG(getQuantidadeG() - 1) ;
			break;

		}

	}

	@Override
	public void reposicaoEstoque() {
		
		if (getQuantidadeP() <= getEstoqueMinimo()) {
			setQuantidadeP(getEstoqueMaximo());
		
		} else if (getQuantidadeM() < getEstoqueMinimo()) {
			setQuantidadeM(getEstoqueMaximo());
		} else if (getQuantidadeG() < getEstoqueMinimo()) {
			setQuantidadeG(getEstoqueMaximo()); 
		}
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeP() {
		return quantidadeP;
	}

	public void setQuantidadeP(int quantidadeP) {
		this.quantidadeP = quantidadeP;
	}

	public int getQuantidadeM() {
		return quantidadeM;
	}

	public void setQuantidadeM(int quantidadeM) {
		this.quantidadeM = quantidadeM;
	}

	public int getQuantidadeG() {
		return quantidadeG;
	}

	public void setQuantidadeG(int quantidadeG) {
		this.quantidadeG = quantidadeG;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}
	
	@Override
	public String toString() {
		return descricao + ", quantidade de roupas P no estoque: " + quantidadeP + ", quantidade de roupas M no estoque: " + quantidadeM
				+ ", quantidade de roupas G no estoque: " + quantidadeG ;
	}
}
