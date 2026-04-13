/*5. Agregar métodos a la clase Fecha para proporcionar las siguientes operaciones: 
 * verificar si una fecha es mayor, menor o igual a otra fecha dada, 
 * calcular la cantidad de días entre dos fechas, calcular una nueva fecha a partir de una fecha y
 *  una cantidad de días que se suman (o restan según su signo) a la misma, 
 *  devolver el día de la semana de una fecha dada.*/	

package fecha;

public class TextFecha {
	public static void main(String[] args) {
		Fecha fecha1 = new Fecha(28, 02, 2006);
		Fecha fecha2 = new Fecha(27, 05, 2006);
		
		int comparativa = fecha1.Comparar(fecha2);
		
		if(comparativa > 0) {
			System.out.println("La fecha "+fecha1+" Es mayor a "+fecha2);
		}else if(comparativa < 0) {
			System.out.println("La fecha "+fecha1+" Es Menor a "+fecha2);
		}else {
			System.out.println("Las fechas "+fecha1+" y "+ fecha2+ " Son iguales");
		}
		
		int cantidad = fecha1.ContadorDia(fecha2);
		System.out.println("La cantidad de dias entre "+fecha1+ "y "+fecha2+" es "+ cantidad);
		
		//Fecha1
		System.out.println("Fecha inicial: "+ fecha1);
		
		fecha1.diaAnterior();
		System.out.println("dia anterior: "+ fecha1);
		
		fecha1.diaSiguiente();
		System.out.println("dia siguente: "+ fecha1);
		
		//Fecha2
		System.out.println("Fecha inicial: "+ fecha2);
		
		fecha2.diaAnterior();
		System.out.println("dia anterior: "+ fecha2);
		
		fecha2.diaSiguiente();
		System.out.println("dia siguente: "+ fecha2);
		
	}
}
