package testnormal;
import net.datastructures.*;

public class TestAddBefore {
	public static void main(String[] args){
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		list.addLast("Juan");
		list.addLast("Ana");
		list.addLast("Juan");
		list.addLast("Mariela");
		list.addLast("Juan");
		
		
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		listRes.addLast("Omar");
		listRes.addLast("Juan");
		listRes.addLast("Ana");
		listRes.addLast("Omar");
		listRes.addLast("Juan");
		listRes.addLast("Mariela");
		listRes.addLast("Omar");
		listRes.addLast("Juan");

		//Muestro ambas listas
		System.out.println("Lista original: "+list);
		System.out.println("Lista Res: "+listRes);


		/* Esta comparando ambas listas si son iguales
		Assert.assertEquals(3, list.addBefore("Omar", "Juan"));
		Assert.assertEquals(8, list.size());
		Assert.assertEquals(listRes, list);*/
		
		int n = list.addBefore("Omar", "Juan");
		System.out.println("Agregados: "+n);
		System.out.println("Lista alterada: "+list);
		System.out.println("Tamaño de la lista: "+list.size());

		System.out.println("La lista es igual ala listaRes? "+list.equals(listRes));

	}
}
