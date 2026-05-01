package banco;

import java.util.Arrays;
import java.util.Objects;

public class Cliente {
	private String nombre;
	private String mail;
	private Activo[] activos;
	private int cantidadActivos = 0;
	private static final int MAX_ACTIVOS = 10;
	
	
	public Cliente(String nombre,String email) {
		this.nombre = nombre;
		this.mail = email;
		//Inicializamos el arreglo
		this.activos = new Activo[MAX_ACTIVOS];
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Agrega nuevos activos al cliente. Si el título no está en sus activos, lo
	 * agrega. Si ya está en sus activos, incrementa su cantidad.
	 * 
	 * @param titulo:   título comprado
	 * @param cantidad: cantidad de títulos comprados
	 * @throws ArrayIndexOutOfBoundsException: supera la cantidad máxima de títulos
	 *                                         distintos que puede tener un cliente
	 */
	public void  comprarActivo(Titulo titulo, int cantidad) {
		if(cantidadActivos >= MAX_ACTIVOS) {
			throw new ArrayIndexOutOfBoundsException("Supera la cantidad maxima de titulos!");
		}
		for(int i = 0; i < cantidadActivos; i++) {
			if(activos[i].getTitulo().equals(titulo)) {
				activos[i] = new Activo(activos[i].getCantidad() + cantidad, titulo);
				return;
			}
		}
		activos[cantidadActivos++] = new Activo(cantidad, titulo);
		
	}
	
	/**
	 * Realiza la sumatoria de todos los activos del cliente. Multiplica el precio
	 * de cada título por la cantidad que tiene comprada.
	 * 
	 * @return valuación de la activos del cliente
	 */
	public double totalActivo() {
		double total = 0;
		for(int i = 0; i < cantidadActivos; i++) {
			total += activos[i].getTitulo().getPrecio() * activos[i].getCantidad();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(activos);
		result = prime * result + Objects.hash(cantidadActivos, mail, nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Arrays.equals(activos, other.activos) && cantidadActivos == other.cantidadActivos
				&& Objects.equals(mail, other.mail) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", mail=" + mail + ", activos=" + Arrays.toString(activos)
				+ ", cantidadActivos=" + cantidadActivos + "]";
	}
	
	
}
