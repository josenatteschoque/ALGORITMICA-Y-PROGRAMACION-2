/*. El sueldo de un médico es una vez y media el básico más un 20% del básico por cada año de antigüedad.*/
package hospital;

public class Medico extends Personal {
	private Turno turno;
	
	public Medico(int legajo, String nombre, int antiguedad) {
		super(legajo, nombre, antiguedad);
	}

	//Getters y Setters
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	//sueldo = (básico * 1.5) + (básico * 0.20 * antigüedad)
	@Override
	public double CalcularSueldo() {
		double basico = Personal.getBasico();
		double sueldo = (basico * 1.5) + (basico * 0.20 * getAntiguedad());
		return sueldo;
	}

	@Override
	public String toString() {
		return "Medico [CalcularSueldo()=" + CalcularSueldo() + ", getLegajo()=" + getLegajo() + ", getNombre()="
				+ getNombre() + ", getAntiguedad()=" + getAntiguedad() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}

	
	
}
