package empleados;

public class Empleado {
	protected String nombre;
	protected int documento;
	
	//Cosntructor
	public Empleado(String nombre, int documento) {
		this.nombre = nombre;
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}
	
	//Metodo toString
	public String toString() {
		return"nombre: "+nombre+" Dni: "+documento;
	}
}
