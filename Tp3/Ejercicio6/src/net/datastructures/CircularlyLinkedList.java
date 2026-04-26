/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.datastructures;

/**
 * An implementation of a circularly linked list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CircularlyLinkedList<E> {
  //---------------- nested Node class ----------------
  /**
   * Singly linked node, which stores a reference to its element and
   * to the subsequent node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;     // an element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;  // a reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the CircularlyLinkedList
  /** The designated cursor of the list */
  private Node<E> tail = null;                  // we store tail (but not head)

  /** Number of nodes in the list */
  private int size = 0;                         // number of nodes in the list

  /** Constructs an initially empty list. */
  public CircularlyLinkedList() { }             // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return tail.getNext().getElement();         // the head is *after* the tail
  }

  /**
   * Returns (but does not remove) the last element of the list
   * @return element at the back of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Rotate the first element to the back of the list.
   */
  public void rotate() {         // rotate the first element to the back of the list
    if (tail != null)                // if empty, do nothing
      tail = tail.getNext();         // the old head becomes the new tail
  }

  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    if (size == 0) {
      tail = new Node<>(e, null);	//Crea un nuevo nodo con el elemento y apunta a nada
      tail.setNext(tail);                     // link to itself circularly
    } else {
      Node<E> newest = new Node<>(e, tail.getNext());	//Crea un nuevo nodo llamado newest que apunta ala cola
      tail.setNext(newest);		//tail le asigna a newest
    }
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    addFirst(e);             // insert new element at front of list
    tail = tail.getNext();   // now new element becomes the tail
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    Node<E> head = tail.getNext();
    if (head == tail) tail = null;           // must be the only node left
    else tail.setNext(head.getNext());       // removes "head" from the list
    size--;
    return head.getElement();
  }

  
  /* Inserta el elemento e en la posicion n de la lista */	
  //public void addPos(E e, int n) throws IndexOutOfBoundsException
  public void addPos(E e, int n) throws IndexOutOfBoundsException{
	  if(n < 0 ) throw new IndexOutOfBoundsException("La posicion no puede ser negativa!");
	  if(n > size) throw new IndexOutOfBoundsException("La posicion no puede ser mayor al tamaño de la lista");
	  if(n == 0) {	//En caso de que sea la primer posicion 
		  addFirst(e);
	  }else if(n == size) {	//En caso de que sea la ultima posicion 
		  addLast(e);
	  }else {
		  Node<E> actual = tail;
		  Node<E> anterior = null;
		  
		  int c = 0;
		  //Recorre la lista hasta la posicion solicitada
		  do {
			  anterior = actual; 
			  actual = actual.getNext();	//Apunta al siguiente elemento
			  c++;
		  }while(c < n);
		  
		  Node<E> nuevo = new Node<>(e,actual);
		  anterior.setNext(nuevo);
		  size++;
	  }
  }
  //Funciona siuuu :)

  
  /* Elimina el elemento e de la lista 
  /* Retorna NULL si no lo encuentra */
  //public E removeElement(E e) Metodo que sirve para eliminar un elemento e de la lista
  public E removeElement(E e) {
	  if (isEmpty()) return null;	//Retorna null si la lista esta vacia
	  Node<E> anterior = tail;	//El anterior empieza en la cola
	  Node<E> nuevo = tail.getNext();	//El nuevo empiza en la cabeza 
	  
	  //Recorre la lista
	  for(int i = 0; i < size; i++) {
		  if(nuevo.getElement().equals(e)) {	//Encontramos el elemento
			  if(size == 1) {
				  //Caso especial en que la lista se queda vacia  
				  tail = null;
			  }else {
				  //El anterior salta hacia al siguiente
				  anterior.setNext(nuevo.getNext());

				  //Si borramos el node que era la cola ahora la cola es el anterior 
				  if(nuevo == tail) {
					  tail = anterior;
				  }
			  }
			  size--;	//Declemento el tamaño de la lista 
			  return nuevo.getElement();	//Retorno el valor y salimos
		  }
		  anterior = nuevo;	//El anterior ahora apunta al siguiente
		  nuevo = nuevo.getNext();	//Avanza al siguiente elemento de la lista
	  }
	  return null;	//Si no esta en la lista retorna null
  }
//Funciona siuuu :)

  
  /* Elimina elemento que se encuentra en la posicion n de la lista */
  /* Retorna NULL si no es una posición valida */
  //public E removePos(int n) throws IndexOutOfBoundsException Metodo que sirve para eliminar un elemento de la lista en la posicion n
  public E removePos(int n) throws IndexOutOfBoundsException{
	  if(n < 0) throw new IndexOutOfBoundsException("La posicion no debe de ser negativa!");
	  if(n > size) throw new IndexOutOfBoundsException("La posicion no debe de ser mayor al tamaño de la lista!");
	  if(n == 0) {
		  removeFirst();	//Si el elemento a eliminar es el primero uso el metodo removefirst()
	  }
	  
	  if(isEmpty()) return null;
	  Node<E> anterior = tail;
	  Node<E> actual = tail.getNext();

	  //Recorre la lista
	  int c=0;
	  while(c < n) {
		anterior = actual;
		actual = actual.getNext();	//Avanza al siguiente elemento de la lista
		c++;
	  }
	  anterior.setNext(actual.getNext());	//El anterior salta al siguiente haci elimina el elemento 
	  
	  //Si justo borramos el último nodo, actualizamos la cola
	   if (actual == tail) {
	       tail = anterior;
	   }
	  size--;	//Declemento el tamaño de la lista
	  return null;
  }
  //Funciona siuuuu :)
  
  
  /* Inserta todos los elementos de la Lista l al final de la lista */
  //public void concatenate(CircularlyLinkedList<E> l)
  public void concatenate(CircularlyLinkedList<E> lista2) {
	  if(lista2.isEmpty()) return;
	  
	  if(isEmpty()) {
		  this.tail = lista2.tail;
		  this.size = lista2.size;
	  }else {
		  //Guardo las cabezas
		  Node<E> headA = this.tail.getNext();
		  Node<E> headB = lista2.tail.getNext();
		  
		  //Apunta ala cabeza de la siguiente lista
		  this.tail.setNext(headB);
		  
		  //El final de la lista ahora apunta ala cola de la lista principal
		  lista2.tail.setNext(headA);
		  
		  //El nuevo 'tail' de la lista total es el tail de la lista2
		  this.tail = lista2.tail;
		  
		  //Sumamos los tamaños de las listas
		  this.size += lista2.size;
	  }
  }
  //Funciona siuuu :)
  
  
  /* Busca el elemento e dentro de la lista */
  /* Retorna el elemento si lo encuentra o Null si no está en la lista */
  //public E search(E e) Metodo que sirve para buscar un elemento en la lista
  public E search(E e) {
	  
	  Node<E> walk = tail; 

	  //Recorre la lista
	  do {
		  if(walk.getElement().equals(e)) {
			  return walk.getElement();
		  }
		  
	      walk = walk.getNext();	//Apunta al siguiente elemento
	    } while (walk != tail);
	  
	  return null;	//Si no esta en la lista retorna null
  }
  //pude hacerlo siuuuuuuu
  
  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    if (tail == null) return "()";	//Si la lista esta vacio retorna ()
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = tail;
    do {
      walk = walk.getNext();	//Apunta al siguiente elemento
      sb.append(walk.getElement());	//Trae al elemento siguiente
      if (walk != tail)
        sb.append(", ");
    } while (walk != tail);
    sb.append(")");
    return sb.toString();
  }
}
