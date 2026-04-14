/*6. Crear una clase llamada ConjuntoEnteros. Cada objeto ConjuntoEntero puede almacenar enteros en el rango de 0 a 100. El conjunto se representa mediante un arreglo de valores boolean. El elemento del arreglo a[j] es false si el entero j no se encuentra dentro del conjunto. El constructor sin argumentos inicializa el arreglo con el “conjunto vacío” (el arreglo con todos sus valores en false) 

Proporcionar los siguientes métodos: 
a) insertarElemento - inserta un nuevo entero k en el conjunto (a[k] en true)
b) eliminarElemento - elimina el entero k del conjunto (a[k] en false)
c) aStringConjunto - devuelve una cadena que muestra los elementos que están en el conjunto separados por espacios. 
d) esIgualA - determina si dos conjuntos son iguales
e) union - crea un tercer conjunto con la unión de dos conjuntos dados
f) interseccion - crea un tercer conjunto con la intersección de dos conjuntos dados.
g) diferencia - crea un tercer conjunto con todos los elementos que están en el primero conjunto y no están en el segundo.*/

package conjuntoentero;

public class ConjuntoEnteros {
	private boolean []conjunto;
	
	//Constructor: inicializa el conjunto vacio
	public ConjuntoEnteros() {
		this.conjunto = new boolean[101];
	}
	
	//Metodo insertarElemento - inserta un nuevo entero k en el conjunto (a[k] en true)
	public void InsertarElemento(int k) {
		if(k >= 0 && k <= 100) {
			conjunto[k] = true;
		}
	}

	//Metodo eliminarElemento - elimina el entero k del conjunto (a[k] en false)
	public void EliminarElemento(int k) {
		if(k >= 0 && k <= 100) {
			conjunto[k] = false;
		}
	}
	//Metodo aStringConjunto - devuelve una cadena que muestra los elementos que están en el conjunto separados por espacios
	public String aStringConjunto() {
		String resultado = "";
		boolean vacio = true;
		for(int i = 0; i <= 100; i++) {
			if(conjunto[i]) {
				resultado = resultado + i +" ";
				vacio = false;
			}
		}
		
		if(vacio) {
			return "----";
		}else {
			return resultado.trim();
		}
	}
	
	//esIgualA - determina si dos conjuntos son iguales
	public boolean esIgual(ConjuntoEnteros otro) {
		for(int i = 0; i <= 100;i++) {
			if(this.conjunto[i] != otro.conjunto[i]) {
				return false;
			}
		}
		return true;
	}
	
	//Metodo union - crea un tercer conjunto con la unión de dos conjuntos dados
	public static ConjuntoEnteros Union(ConjuntoEnteros c1, ConjuntoEnteros c2) {
		ConjuntoEnteros resultado = new ConjuntoEnteros();
		
		for(int i = 0; i <= 100; i++) {
			if(c1.conjunto[i] || c2.conjunto[i]) {
				resultado.InsertarElemento(i);
			}
		}
		return resultado;
	}
	
	//Metodo interseccion - crea un tercer conjunto con la intersección de dos conjuntos dados.
	public static ConjuntoEnteros Interseccion(ConjuntoEnteros c1, ConjuntoEnteros c2) {
		ConjuntoEnteros resultado2 = new ConjuntoEnteros();
		
		for(int i = 0; i <= 100; i++) {
			if(c1.conjunto[i] && c2.conjunto[i]) {
				resultado2.InsertarElemento(i);
			}
		}
		return resultado2;
	}
	
	//Metodo diferencia - crea un tercer conjunto con todos los elementos que están en el primero conjunto y no están en el segundo.
	public static ConjuntoEnteros Diferencia(ConjuntoEnteros c1, ConjuntoEnteros c2) {
		ConjuntoEnteros resultado3 = new ConjuntoEnteros();
		
		for(int i = 0; i <= 100; i++) {
			if(c1.conjunto[i] && !c2.conjunto[i]) {
				resultado3.InsertarElemento(i);
			}
		}
		return resultado3;
	}
}
