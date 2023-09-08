package Principal;

import java.util.Scanner;

public class cesarCifra {
	  public static void main(String[] args)  {
	        
	        Scanner entrada = new Scanner(System.in);
	        System.out.println("Programa forca Bruta - Cifra de Cesar");
	        System.out.print("Informe o texto a ser descriptografado: ");
	        String textoCriptografado = entrada.nextLine();
	        System.out.println("\nResultados: \n");
	        String texto;
	        for (int chave = 1;chave<=26;chave++)  {
	            // texto = decriptar(i, textoCriptografado);
	            // inicio descriptografia 
	                String textoNormal = new String();
	                int tamanhoTexto = textoCriptografado.length();
	                int letraDecifradaASCII;
	                    // Descriptografa cada caractere por vez 
	                for(int c=0; c < tamanhoTexto; c++){
	                // Transforma o caracter em codigo ASCII e                 // descriptografa
	                int letranormal = ((int) textoCriptografado.charAt(c));
	                letraDecifradaASCII = letranormal - chave;
	             // Transforma codigo ASCII criptografado em 
	                // caractere ao novo texto
	                textoNormal=textoNormal + ( (char)  letraDecifradaASCII);
	                }
	                
	                System.out.println("Chave " + chave + ": "+textoNormal);
	            }

	}
}
