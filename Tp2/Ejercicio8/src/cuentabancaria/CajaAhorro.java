package cuentabancaria;

public class CajaAhorro extends CuentaBancaria{

	//Constructor
	public CajaAhorro(int numeroCuenta, String titular, double saldo, int cuil, String direccion, String email) {
		super(numeroCuenta, titular, saldo, cuil, direccion, email);	//Llama al constructor de la superclase
	}
	
	public void Depositar(double monto) {
		if(monto > 0) {
			saldo += monto;
			System.out.println("Deposito exitoso. saldo actual: "+saldo);
		} 
	}
	
	public void Extraer(double monto) {
		if(monto <= saldo) {
			saldo -= monto;
			System.out.println("Extraccion exitosa. saldo actual: "+saldo);
		}else {
			System.out.println("Saldo insuficiente!");
		}
	}

	@Override
	public String toString() {
		return "CajaAhorro [numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + ", cuil="
				+ cuil + ", direccion=" + direccion + ", email=" + email;
	}
	
	
}
