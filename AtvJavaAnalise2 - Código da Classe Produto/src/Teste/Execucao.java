package Teste;

public class Execucao {

	public static void main(String[] args) {
		
		try {
		    Produto teste1 = new Produto(1, "Shampoo Eudora Siage - Reconstrução", 69.99);
		    System.out.println("Código do Produto || Nome do Produto || Preço");
		    System.out.println(teste1.getCodigo()+", "+teste1.getNome()+", "+teste1.getPreco());
		    Produto teste3 = new Produto(2,"Sabonete La Roche Posay - 200ml",79.00);
		    System.out.println(teste3.getCodigo()+", "+teste3.getNome()+", "+teste3.getPreco());
		    
		    Produto teste2 = new Produto(0,"",0);
		    
		}catch (IllegalArgumentException e) {
		    System.out.println("Erro: " + e.getMessage());
		}

	}

}
