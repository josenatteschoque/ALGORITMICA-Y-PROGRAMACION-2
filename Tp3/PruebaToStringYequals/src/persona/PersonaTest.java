package persona;

public class PersonaTest {
	public static void main(String[] args) {
		Persona a1 = new Persona("jose", 20);
		Persona a2 = new Persona("marcelo", 42);
		
		Persona a3 = new Persona("", 42);
		Persona a4 = new Persona("", 42);

		//Sin el metodo toString solo muestra las direcciones
		System.out.println("La persona 1 es:"+a1);
		System.out.println("La persona 2 es:"+a2);
		
		System.out.println("Persona3 Es igual a Persona4?:"+a3.equals(a4));
		if(a3 == a4) {
			System.out.println("Persona3 Es igual a Persona4");
		}else {
			System.out.println("Persona3 no es igual a persona4");
		}
	}
}
