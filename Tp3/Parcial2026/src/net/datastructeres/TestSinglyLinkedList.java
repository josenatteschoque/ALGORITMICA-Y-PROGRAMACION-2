package net.datastructeres;

public class TestSinglyLinkedList {
    public static void main(String[] args) {
        
        // Creo una lista de String
        SinglyLinkedList<String> lista = new SinglyLinkedList<>();
        
        lista.addLast("jose");
        lista.addLast("lucia");
        lista.addLast("pepe");
        lista.addLast("lucia");
        lista.addLast("juana");
        
        System.out.println("Lista: " + lista);
        System.out.println("Tamaño: " + lista.size());
        
        int n = lista.addBefore("pedro", "lucia");
        
        System.out.println("Agregados: " + n);
        System.out.println("Lista modificada: " + lista);
        System.out.println("Nuevo tamaño: " + lista.size());
    }
}