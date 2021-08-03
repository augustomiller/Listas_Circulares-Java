package com.github.maicmiller;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

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
