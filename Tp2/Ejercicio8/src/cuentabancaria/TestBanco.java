package cuentabancaria;

public class TestBanco {
	public static void main(String[] args) {
		System.out.println("Prueba Caja Ahorro");
		CajaAhorro a1 = new CajaAhorro(105, "jose", 0, 94587167, "calle falsa" , "josenattes@gmail.com");
		
		a1.Depositar(5000);
		a1.Extraer(2000);
		a1.Extraer(3500);
		
		System.out.println(a1.toString());
		
		System.out.println("Prueba cuenta corriente");
		
		CuentaCorriente a2 = new CuentaCorriente(99, "minina", 10, 12345678, "calle michi", "minina@gmail.com" ,5000);
		
		a2.Depositar(2000);
		a2.Extraer(10000);
		
		System.out.println(a2.toString());
	}
}
