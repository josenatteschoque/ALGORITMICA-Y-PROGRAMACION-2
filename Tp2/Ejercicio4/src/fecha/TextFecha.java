/*4. Crear la clase Fecha para trabajar con fechas. La clase debe registrar año, mes y día. Verificar la consistencia de los datos. Agregar los siguientes métodos:
a) diaSiguiente - incrementa la fecha en un día.
b) diaAnterior - decrementa la fecha en un día.*/

package fecha;

public class TextFecha {
	public static void main(String[] args) {
		Fecha fecha1 = new Fecha(01, 04, 2006);
		Fecha fecha2 = new Fecha(01, 03, 2024);
		
		System.out.println("Fecha inicial: "+ fecha1);
		
		fecha1.diaAnterior();
		System.out.println("dia anterior: "+ fecha1);
		
		fecha1.diaSiguiente();
		System.out.println("dia siguente: "+ fecha1);
		
		
		System.out.println("Fecha inicial: "+ fecha2);
		
		fecha2.diaAnterior();
		System.out.println("dia anterior: "+ fecha2);
		
		fecha2.diaSiguiente();
		System.out.println("dia siguente: "+ fecha2);
		
	}
}
