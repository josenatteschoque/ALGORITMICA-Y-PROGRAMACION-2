package cuentabancaria;

public class CuentaCorriente extends CuentaBancaria{
	double limiteNegativo;
	
	//Constructor
	public CuentaCorriente(int numeroCuenta, String titular, double saldo, int cuil, String direccion, String email, double limiteNegativo) {
		super(numeroCuenta, titular, saldo, cuil, direccion, email);	//Llama al constructor de la superclase
		this.limiteNegativo = limiteNegativo;
	}
	
	public void Depositar(double monto) {
		saldo += monto;
		System.out.println("Deposito exitoso. saldo actual: "+saldo);
	}
	
	public void Extraer(double monto) {
		if(monto <= (saldo+limiteNegativo)) {
			saldo -= monto;
			System.out.println("Extraccion exitosa. saldo actual: "+ saldo);
		}else {
			System.out.println("Limite alcanzado!");
		}
	}

	@Override
	public String toString() {
		return "CuentaCorriente [limiteNegativo=" + limiteNegativo + ", numeroCuenta=" + numeroCuenta + ", titular="
				+ titular + ", saldo=" + saldo + ", cuil=" + cuil + ", direccion=" + direccion + ", email=" + email;
	}

	
	
	
}
