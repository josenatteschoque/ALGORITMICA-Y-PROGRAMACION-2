/*Crear la clase CuentaBancaria la misma debe registrar el número de cuenta, titular y saldo.
 *  Crear la clase CajaAhorro que extiende de CuentaBancaria en la misma se puede hacer depósitos 
 *  y extracciones siempre que el saldo sea mayor o igual a cero. Crear la clase CuentaCorriente que 
 *  también extiende de CuentaBancaria, aquí también los clientes puede hacer depósitos y extracciones, 
 *  en este caso puede tener un saldo negativo hasta determinado monto fijado para cada cliente. De cada 
 *  cliente se registra su nombre, cuit, dirección y email. Escribir un programa que cree instancias de objetos 
 *  para cada clase y realizar depósitos y extracciones.*/

package cuentabancaria;

public class CuentaBancaria {
	protected int numeroCuenta;
	protected String titular;
	protected double saldo;
	
	protected int cuil;
	protected String direccion;
	protected String email;

	
	//Constructor
	public CuentaBancaria(int numeroCuenta, String titular, double saldo, int cuil, String direccion, String email) {
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = saldo;
		this.cuil = cuil;
		this.direccion = direccion;
		this.email = email;
	}
	
}
