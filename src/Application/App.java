package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Acessorio;
import entities.Item;
import entities.RoupaPMG;
import entities.RoupaTamanhoUnico;
public class App {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Item[] vect = new Item[5];
		
		vect[0] = new Acessorio("Brinco", 20, 1, 40);
		vect[1] = new RoupaTamanhoUnico("Jaqueta", 8, 1, 16);
		vect[2] = new RoupaPMG("Blusa", 10, 10, 10, 1, 20);
		vect[3] = new Acessorio("Cinto", 5, 1, 10);
		vect[4] = new RoupaTamanhoUnico("Saia", 6, 1, 12);
		
			process(vect);
			sc.close();
			
		}
	

	static void process(Item[] vect) {
		int r=0;
		do {
		System.out.println("Menu:");
		System.out.println("0-Brinco");
		System.out.println("1-Jaqueta");
		System.out.println("2-Blusa");
		System.out.println("3-Cinto");
		System.out.println("4-Saia");
		System.out.println("5-Fim do programa");
		
		try {
		r = sc.nextInt();
		if (r != 5) {
			vect[r].venda();
			vect[r].reposicaoEstoque();
			System.out.println("Vendido/a: " + vect[r].toString());
		}
		else {
			System.out.println("Fim do programa");
		}
		}catch(InputMismatchException e) {
			System.out.println("Entrada inválida. Digite um número inteiro.");
			sc.next();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Entrada inválida. Digite um número permitido.");
		}catch(IllegalArgumentException e) {
			System.out.println("Não foi possivel proceder com a venda. "+ e.getMessage());
	
			
		}
	}while (r != 5);

	}

}
