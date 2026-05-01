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
package singlylinkedlist;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

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

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list

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
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }


  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
    if (size != other.size) return false;
    Node walkA = head;                               // traverse the primary list
    Node walkB = other.head;                         // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // if we reach this, everything matched successfully
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) {                    // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // walk through remainder of original list
      Node<E> otherTail = other.head;     // remember most recently created node
      while (walk != null) {              // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
    }
    return h;
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
  
  /* Inserta el elemento e en la posicion n de la lista */	
  //public void addPos(E e, int n) throws IndexOutOfBoundsException Metodo que inserta el elemento en la posicion n
  public void addPos(E e, int n) throws IndexOutOfBoundsException{
	  //Muestro estos mensajes de excepciones 
	  if(n < 0 ) throw new IndexOutOfBoundsException("La posicion no puede ser negativa!");
	  if(n > size) throw new IndexOutOfBoundsException("La posicion no puede ser mayor al tamaño de la lista");
	  if(n == 0) {	//En caso de que sea la primer posicion 
		  addFirst(e);
		  }	
	  else if(n == size) {	//En caso de que sea la ultima posicion 
		  addLast(e);
	  }else {
		  Node<E> actual = head;
		  Node<E> anterior = null;
		  int c = 0;
		  while(c < n) {
			  anterior = actual;
			  actual = actual.getNext();
			  c++;
		  }
		  Node<E> nuevo = new Node<>(e, actual);	//Creo un nuevo Node
		 anterior.setNext(nuevo);
		 size++;
	  }
  }
  //Funciona siuuuu :)
  
  /* Elimina el elemento e de la lista 
  /* Retorna NULL si no lo encuentra */
  //public E removeElement(E e) Metodo que sirve para eliminar un elemento en la lista
  public E removeElement(E e) {
	  	if(isEmpty()) return null;	//si la lista esta vacia retorna null
	  	Node<E> walk = head;	
	  	Node<E> anterior = null;  
	  	
	  	while(walk != null) {	//Recorre la lista
	  		if(walk.getElement().equals(e)) {
	  			
	  			if(anterior == null) {
	  				head = walk.getNext();
	  			}else {
	  				anterior.setNext(walk.getNext());
	  			}
	  			size--;
	  		}
	  		anterior = walk;
	  		walk = walk.getNext();	//Avanza al siguiente elemento
	  	}
	  	return null;	//Si no esta el elemento en la lista retorna null
  }
  //Funciona siuuuu :)
  

  /* Elimina elemento que se encuentra en la posicion n de la lista */
  /* Retorna NULL si no es una posición valida */
  //public E removePos(int n) throws IndexOutOfBoundsException Metodo que sirve para eliminar un elemento en la posicion n de la lista
  public E removePos(int n) throws IndexOutOfBoundsException{
	//Muestro estos mensajes de excepciones 
	  if(n < 0 ) throw new IndexOutOfBoundsException("La posicion no puede ser negativa!");
	  if(n > size) throw new IndexOutOfBoundsException("La posicion no puede ser mayor al tamaño de la lista");
	  if(isEmpty()) return null;

	  Node<E> walk = head;
	  Node<E> anterior = null;
	  int c = 0;
	  
	  //Recorro la lista hasta encontrar la posicion del elemento a eliminar 
	  while(c < n) {
		  anterior = walk;
		  walk = walk.getNext();
		  c++;
	  }
	  anterior.setNext(walk.getNext());	//Apunto la referencia al siguiente elemento haci eliminando el deseado
	  return null;	//Si el elemento no esta en la lista retorna null
  }	
  //Funciona siuuuuuu :)

  
	
/* Inserta todos los elementos de la Lista l al final de la lista */
//public void concatenate(SinglyLinkedList<E> l) Metodo que sirve para insertar todos los elementos de una lista al final de otro lista
  public void concatenate(SinglyLinkedList<E> lista2) {
	  //Si la lista esta vacia no modifica lista1 
	  if(lista2.isEmpty()) {
		  return;
	  }
	  
	  //Si la lista1 esta vacia, las referencias de la lista1 apuntan a lista2
	  if(isEmpty()) {
		  this.head = lista2.head;
		  this.tail = lista2.tail;
		  this.size = lista2.size;	
		  return;
	  }
	  
	  //Apunta las referencias ala siguiente lista
	  this.tail.setNext(lista2.head);
	  this.tail = lista2.tail;
	  this.size += lista2.size; 
  }
//Funciona siuuuuu
  
  /* Busca el elemento e dentro de la lista */
  /* Retorna el elemento si lo encuentra o Null si no está en la lista */
  //public E search(E e) Metodo que sirve para buscar un elemento en la lista
  public E search(E e) {
	  if(isEmpty()) return null;	//En caso de que la lista este vacia retorna null
	  
	  Node<E> walk = head;	//Creo un nuevo Node que apunte a head 
	  
	  while(walk != null) {	//Recorro la lista hasta que termine 
		  if(walk.getElement().equals(e)) {	//Ve si el elemento actual es igual a e
			  return walk.getElement();	//Si son iguales retorna el elemento
		  }
		  walk = walk.getNext();	//Avanza al siguiente
	  }
	  return null;	//Si no lo encontro en la lista retorna null
  }//Funcionaaaa
  
  
  //public void addCombineAfter(SinglyLinkedList<E> l) Metodo que sirve para para combinar una lista con otro de forma cruzada osea lista1 ={a,b,c} y lista2 = {1,2,3}
  //seria {a1,b2,c3}
  public void addCombineAfter(SinglyLinkedList<E> l) {
	  if(l.isEmpty()) return;
	  
	  //Si la lista original esta vacia tomamos toda la lista l
	  if(this.isEmpty()) {
		  this.head = l.head;
		  this.tail = l.tail;
		  this.size = l.size;
		  return;
	  }
	  
	  
	  Node<E> c1 = this.head;
	  Node<E> c2 = l.head;
	  
	  while(c1 != null && c2 != null) {
		  
		  Node<E> siguiente1 = c1.getNext();
		  Node<E> siguiente2 = c2.getNext();
		  
		  c1.setNext(c2);
		  
		  if(siguiente1 == null) {
			  this.tail = l.tail;
			  break;
		  }
		  
		  c2.setNext(siguiente1);
		  
		  //Avanzo los punteros
		  c1 = siguiente1;
		  c2 = siguiente2;
	  }
	  this.size += l.size;
  }
 //Funciona siuuu :)
  
  
//public void addCombineBefore(SinglyLinkedList<E> l) Metodo que sirve para
	// combinar una lista con otra pero antes de primer elemento ejemplo lista1 =
	// {a,b,c} y lista2 = {x,y,z}
	// {xa, yb, zc}
	public void addCombineBefore(SinglyLinkedList<E> l) {
		 if(l.isEmpty()) return;
		  
		  //Si la lista original esta vacia tomamos toda la lista l
		  if(this.isEmpty()) {
			  this.head = l.head;
			  this.tail = l.tail;
			  this.size = l.size;
			  return;
		  }
		  
		  Node<E> c2 = l.head;
		  Node<E> c1 = this.head;
		  
		  this.head = c2;
		  
		  while(c1 != null && c2 != null) {
			  Node<E> next2 = c2.getNext();
			  Node<E> next1 = c1.getNext();
			  
			  c2.setNext(c1);
			  
			  if(next2 == null) {
				  break;
			  }
			  
			  if(next1 == null) {
				  c1.setNext(next2);
				  this.tail = l.tail;
				  break;
			  }
			  
			  c1.setNext(next2);
			  
			  c2 = next2;
			  c1 = next1;
		  }
		  this.size += l.size;
	}
//Funciona siuu :)
	
	
	/**
	 * Elimina todos los elementos que están en una posición impar. 
	 * Retorna una lista con los elementos eliminados
	 *
	 * Por ejemplo:
	 *
	 * {A, B, C, D} => {A, C} retorna la lista {B, D}
	 *
	 * {A, B, C} => {A, C} retorna la lista {B}
	 *
	 * {A, B} => {A} retorna la lista {B}
	 * 
	 * {A} => {A} retorna la lista {} 
	 * 
	 * {} => {} retorna la lista {} 
	 */
	public SinglyLinkedList<E> removeOdd(){
		SinglyLinkedList<E> removeList = new SinglyLinkedList<>();	//Lista donde estaran los elementos de posiciones impares
		
		if(head == null || head.getNext() == null) {
			return  removeList;	//Si la lista esta vacia o solo tiene un elemento 
		}
		
		Node<E> walk = head;
		while(walk != null) {
			
			Node<E>siguiente = walk.getNext();
			
			removeList.addLast(siguiente.getElement());	//Agrego el elemento en la nueva lista
			
			walk.setNext(siguiente.getNext());	//Salto al siguiente elemento
		
			if(walk.getNext() == null) {	//actualizo el tail
				tail = walk;
			}
			size--;	//Declementa el tamaño de la lista	
			walk = walk.getNext();	//Avanza al siguiente elemento
		}
		return removeList;	//Retorna la lista de elementos eliminados
	}
//Funciona siuuu :)
	
	/**
	 * Retorna una nueva lista con los n elementos comenzado desde la derecha
	 * 
	 * Por ejemplo:
	 * 
	 * Dada la lista {A, B, C, D}
	 * 
	 * right(4) retorna la lista {A, B, C, D}
	 * 
	 * right(3) retorna la lista {B, C, D}
	 * 
	 * right(2) retorna la lista {C, D}
	 * 
	 * right(1) retorna la lista {D}
	 * 
	 * right(0) retorna la lista {}
	 * 
	 * right(5) lanza la excepción IndexOutOfBoundsException
	 * 
	 * right(-1) lanza la excepción IndexOutOfBoundsException
	 * 
	 * 
	 * @param n: número de elementos a retornar comenzando desde la derecha
	 * @return nueva lista con los elementos de la derecha de la lista original
	 * @throws IndexOutOfBoundsException n: supera el tamaño de la lista o es negativo
	 */
	public SinglyLinkedList<E> right(int n) throws IndexOutOfBoundsException{
		//Mensaja de excepcion
		if(n < 0 || n > size) throw new IndexOutOfBoundsException("N supera el tamaño el tamaño de la lista o es negativo!");
		SinglyLinkedList<E> nuevalista = new SinglyLinkedList<>();
		if(n == 0) return nuevalista;
		int saltos = size - n;
		Node<E> walk = head;

		//Avanza hasta la posicion necesaria
		for(int i = 0; i < saltos; i++) {
			walk = walk.getNext();
		}
		
		//Agrega los elementos en al nueva lista
		while(walk != null) {
			nuevalista.addLast(walk.getElement());
			walk = walk.getNext();
		}
		//Retorna la nueva lista
		return nuevalista;
	}


}
