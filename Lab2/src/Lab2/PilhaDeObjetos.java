package Lab2;

public class PilhaDeObjetos {
    public Object[] objetos;
    public int topoDaPilha;
    public int capacidade;
    
    public PilhaDeObjetos(int capacidade) {
        this.capacidade = capacidade;
        objetos = new Object[capacidade];
        topoDaPilha = -1;
    }
    
    public void push(Object objeto) throws PilhaCheiaException {
        if (topoDaPilha == capacidade - 1) {
            throw new PilhaCheiaException("A pilha está cheia.");
        }
        objetos[++topoDaPilha] = objeto;
    }


    public Object pop() throws PilhaVaziaException {
    if (topoDaPilha == -1) {
        throw new PilhaVaziaException("A pilha está vazia.");
    }
    return objetos[topoDaPilha--];
}
}
