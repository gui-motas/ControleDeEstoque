package entities;

import java.util.Scanner;

public class Acessorio extends Peca implements Item {

	Scanner sc = new Scanner(System.in);

	public Acessorio(String descricao, int quantidade, int estoqueMinimo, int estoqueMaximo) {
		super(descricao, quantidade, estoqueMinimo, estoqueMaximo);

	}

	@Override
	public void venda() {
		System.out.println("Digite a quantidade a ser vendida do Acessorio");
	
		int num = sc.nextInt();
		if(num > getQuantidade()) {
			throw new IllegalArgumentException("Não temos a quantidade escolhida no estoque");
		}
		setQuantidade(getQuantidade() - num); 
		
	}

	@Override
	public void reposicaoEstoque() {
		if (getQuantidade() <= getEstoqueMinimo()) {
			setQuantidade(getEstoqueMaximo());
		}
		
	}

}
