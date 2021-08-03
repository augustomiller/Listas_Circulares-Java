package com.github.maicmiller;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0){ // Vamos testar se alista está vazia
            this.cabeca = novoNo;
            this.cauda = this.cabeca; // Se alista está vazia estamos adicionando a referencia da cabeça na cauda...
            this.cabeca.setNoProximo(cauda); // Inserindo a referencia de próxima nó da cabeça  para a calda...
        }else{
            novoNo.setNoProximo(this.cauda); // Se não vamos, inserir o nó no final da calda...
            this.cabeca.setNoProximo(novoNo); //  Agora a cabeça vai apontar para o novo nó (o atual)...
            this.cauda = novoNo; // E a referencia de cauda é o nó inserido atualmente...
        }
        this.tamanhoLista++; // Incrementando o tamanho da lista...
    }

    public void remove(int index){
        if (index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista");
        No<T> noAuxiliar = cauda; // Caso contrario vamos remover...
        if(index == 0){ // Vamos verificar se o índice é zero, se sim, vamos remover a cauda...
            this.cauda = this.cauda.getNoProximo(); // En†ão a cauda deixa de ser a referência e passa a referência para o próximo nó na frente dela...
            this.cabeca.setNoProximo(this.cauda); // Como ainda tenho a cabeça da lista apontando para a cauda antiga, vamos apontar para o nó atual...
        }else if(index == 1){ // Se eu estiver no índice 1, então estarei imediatamente após a cauda...
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo()); // Quando tiramos a referência de um nó, automaticamente a JVM o exclui...
        }else{
            for (int i = 0; i < index -1; i++){ //Se o índice não for 0 e nem 1, vamos correr na lista(sempre no nó anterior "-1") até achar o índice...
                noAuxiliar = noAuxiliar.getNoProximo(); // Pronto, chegamos no nó que queremos excluir...
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo()); // [índice-1]->[índice-2]->[índice-3] então, apontando o índice de [índice-1] para o [índice-3], assim o [índice-2] será excluído automaticamente pela JVM...
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if (this.isEmpty()) // Vamos testar se a lista está vazia...
            throw new IndexOutOfBoundsException("A lista está vazia!");
        if(index == 0){
            return this.cauda;
        }
        No<T> novoAuxiliar = this.cauda; // Caso o índice não seja zero vamos percorrer os elementos...
        for (int i = 0; (i < index) && (novoAuxiliar != null ); i++){
            novoAuxiliar = novoAuxiliar.getNoProximo();
        }
        return novoAuxiliar;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0;
    }

    public int size(){
        return this.tamanhoLista;
    }

}
