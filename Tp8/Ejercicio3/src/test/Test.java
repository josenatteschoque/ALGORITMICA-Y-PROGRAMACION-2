/*3. Realizar un método utilizando Map para verificar si dos listas que contienen cadenas son similares. Dos listas son similares si tienen la misma cantidad de elementos y los mismos elementos sin importar el orden. Los elementos pueden estar duplicados. Realizar una aplicación que pruebe el método implementado.

Por ejemplo la Lista 1 y la Lista 2 son similares.

Lista 1 = “Ana”, “Juan”, “Ana”, “Pedro”, “Ana”
Lista 2 = “Juan”, “Pedro”, “Ana”, “Ana”, “Ana”

public static boolean similar(List<String> l, List<String> s)*/
package test;
import net.datastructures.Map;
import net.datastructures.ChainHashMap;
import net.datastructures.List;
import net.datastructures.ArrayList;

public class Test {
	public static void main(String[] args) {

		String[] array1 = {"Ana", "Juan", "Ana","Pedro", "Ana"};
		String[] array2 = {"Juan", "Pedro", "Ana","Ana", "Ana"};
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		for(int i = 0; i < array1.length; i++) {
			String nombre = array1[i];
			list1.add(i, nombre);
		}
		
		for(int i = 0; i < array2.length; i++) {
			String nombre = array2[i];
			list2.add(i, nombre);
		}
		
		System.out.println(similar(list1, list2));
		
	
	}
	
	public static boolean similar(List<String> l, List<String> s) {
		//Si el tamaño de las listas no son iguales obio no son similares
		if(l.size() != s.size())
			return false;
		
		Map<String, Integer> map1 = new ChainHashMap<>();
		Map<String, Integer> map2 = new ChainHashMap<>();
		
		for(int i = 0; i < l.size(); i++) {
			String nombre = l.get(i);
			Integer cont = map1.get(nombre);

			if(nombre == null) {
				map1.put(nombre, cont);
			
			}else {
				map1.put(nombre, cont + 1);
			}
		}
		
		return false;
	}
}
