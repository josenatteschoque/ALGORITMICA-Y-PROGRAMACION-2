package conjuntoentero;

public class Test {
	public static void main(String[] args) {
		ConjuntoEnteros c1 = new ConjuntoEnteros();
		ConjuntoEnteros c2 = new ConjuntoEnteros();
		
		c1.InsertarElemento(87);
		c1.InsertarElemento(7);
		c1.InsertarElemento(13);

		c2.InsertarElemento(87);
		c2.InsertarElemento(7);
		c2.InsertarElemento(13);
		c2.EliminarElemento(87);
		
		ConjuntoEnteros union = ConjuntoEnteros.Union(c1, c2);
		ConjuntoEnteros inter = ConjuntoEnteros.Interseccion(c1, c2);
		ConjuntoEnteros dife = ConjuntoEnteros.Diferencia(c1, c2);
		
		System.out.println("Conjunto 1: "+c1.aStringConjunto());
		System.out.println("Conjunto 2: "+c2.aStringConjunto());
		System.out.println("La union es: "+ union.aStringConjunto());
		System.out.println("La interseccion es: "+ inter.aStringConjunto());
		System.out.println("La diferencia (c1 - c2):"+ dife.aStringConjunto());
		System.out.println("¿El conjunto A es igual al conjunto B?:"+c1.esIgual(c2));
		
	}
}
