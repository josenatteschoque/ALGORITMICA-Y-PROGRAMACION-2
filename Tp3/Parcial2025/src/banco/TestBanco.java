package banco;

import java.time.LocalDate;

public class TestBanco {
	public static void main(String[] args) {
		
		//Creo acciones
		Accion a1 = new Accion("ALUA", "aluar", 750, false);
		Accion a2 = new Accion("YPF", "YPF", 36100, true);
		
		//Creo los bonos
		Bono b1 = new Bono("AL30", "Bono AL 30", 73500, LocalDate.of(2030, 6, 30));
		Bono b2 = new Bono("GD	30", "Bono GD 30", 74100, LocalDate.of(2035, 9, 30));

		//Creo los clientes
		Cliente c1 = new Cliente("Juan", "juan@gmail.com");
		Cliente c2 = new Cliente("Ana", "ana@gmail.com");
		
		c1.comprarActivo(a1, 1200);
		c1.comprarActivo(b1, 12);
		
		c2.comprarActivo(a2, 150);
		c2.comprarActivo(b2, 45);
		
		c1.comprarActivo(a1, 1500);
		c2.comprarActivo(b2, 35);
		
		//3.1 Llamar al método totalActivo para cada cliente y mostrar su resultado.
		System.out.printf("Total de juan: %.2f %n", c1.totalActivo());
		System.out.printf("Total de ana: %.2f %n", c2.totalActivo());
		
		//3.2 Colocar en un arreglo los objetos a1, a2, b1 y b2. Recorrerlo y llamar a los métodos calcularComision,
		//calcularImpuesto y calcularPrecio para una cantidad de 100 títulos.
		Titulo[] titulos = {a1, a2, b1, b2};
		System.out.println("Calculos para 100 activos");
		
		for(int i = 0; i < titulos.length; i++) {
			int cantidad = 100;
			System.out.printf("CalcularComision: %.2f %n",titulos[i].calcularComision(cantidad));
			System.out.printf("CalcularImpuestos: %.2f %n",titulos[i].calcularImpuesto(cantidad));
			System.out.printf("CalcularPrecio: %.2f %n",titulos[i].calcularPrecio(cantidad));

		}
		
	}
}
