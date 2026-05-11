/*El sueldo de un enfermero es igual al básico más un 10% del básico por cada año de antigüedad*/
package hospital;

public class Enfermero extends Personal{

	public Enfermero(int legajo, String nombre, int antiguedad) {
		super(legajo, nombre, antiguedad);
	}

	@Override
	public double CalcularSueldo() {
		// sueldo = básico + (básico * 0.10 * antigüedad)
		double basico = Personal.getBasico(); 
		double saldo = basico + (basico * 0.10 * getAntiguedad());
		return saldo;
	}

	@Override
	public String toString() {
		return "Enfermero [CalcularSueldo()=" + CalcularSueldo() + ", getLegajo()=" + getLegajo() + ", getNombre()="
				+ getNombre() + ", getAntiguedad()=" + getAntiguedad() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}

	
	
}
