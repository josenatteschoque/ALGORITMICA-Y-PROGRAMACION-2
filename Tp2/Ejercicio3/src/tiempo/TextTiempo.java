/*3. Crear la clase Tiempo para trabajar con tiempos. La clase debe registrar horas, minutos y segundos. Verificar la consistencia de los datos. Agregar los siguientes métodos:
a) incrementarSegundo - incrementa el tiempo en un segundo.
b) incrementarMinuto - incrementa el tiempo en un minuto.
c) incrementarHora -  incrementa el tiempo en una hora.*/

package tiempo;

public class TextTiempo {
	public static void main(String[] args) {

		//Creamos el objeto tiempo
		Tiempo miReloj = new Tiempo(23,58,59);
		
		System.out.println("Tiempo inicial: "+ miReloj.toString());

		//Muestro por pantalla los cambios que realizan los metodos de la clase Tiempo
		miReloj.ingrementarSegundo();
		System.out.println("El tiempo despues de 1 segundo es: "+miReloj.toString());
		
		miReloj.incrementarMinuto();
		System.out.println("El tiempo despues de 1 minuto es: "+miReloj.toString());

		miReloj.incrementarHora();
		System.out.println("El tiempo despues de 1 una hora es: "+ miReloj.toString());
		
	}

}
