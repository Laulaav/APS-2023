package Lab2;

public class Run {

	public static void main(String[] args) {
		 try {
	            PilhaDeObjetos Pilha = new PilhaDeObjetos(5);
	            Pilha.push("Objeto 1");
	            Pilha.push("Objeto 2");
	            Pilha.push("Objeto 3");
	            System.out.println(Pilha.pop());
	            System.out.println(Pilha.pop());
	            System.out.println(Pilha.pop());
	            System.out.println(Pilha.pop()); // Isso irá lançar uma PilhaVaziaException
	        } catch (PilhaCheiaException erro) {
	            System.out.println(erro.getMessage());
	        }catch(PilhaVaziaException erro){
	        	System.out.println(erro.getMessage());
	        }

	}

}
