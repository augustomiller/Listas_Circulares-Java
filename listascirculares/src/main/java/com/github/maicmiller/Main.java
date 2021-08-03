package com.github.maicmiller;

public class Main {
    public static void main(String[] args) {

        ListaCircular<String> listaCircular = new ListaCircular<>();

        listaCircular.add("c0");
        System.out.println(listaCircular);

        // Vamos resolver o índice 0...
        listaCircular.remove(0);
        System.out.println(listaCircular);

        listaCircular.add("c1");
        System.out.println(listaCircular);

        listaCircular.add("c2");
        listaCircular.add("c3");
        System.out.println(listaCircular);

        System.out.println(listaCircular.get(0));
        System.out.println(listaCircular.get(1));
        System.out.println(listaCircular.get(2));
        System.out.println(listaCircular.get(3)); // Volta para o loop contínuo...
        System.out.println(listaCircular.get(4)); // Volta para o loop contínuo seguindo a ordem dos elementos...

        System.out.println("------------------");

        for (int i = 0; i < 20; i++){ // Sempre entrando pela cauda percorrendo até a cabeça e voltando para a cauda (loop = 20)...
            System.out.println(listaCircular.get(i));
        }
    }
}
