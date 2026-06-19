package biblioteca.modelo;

import java.time.LocalDate;

public class Prestamo {

	private Socio socio;
	private Libro libro;
	private LocalDate fechaPrestamo;
	private LocalDate fechaVencimiento;
	private boolean activo;

	public Prestamo(Socio socio, Libro libro, LocalDate fechaPrestamo, LocalDate fechaVencimiento, boolean activo) {
		// TODO: inicializar atributos
        // Nota: al crear un préstamo, activo debe ser true
		super();
		this.socio = socio;
		this.libro = libro;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaVencimiento = fechaVencimiento;
		this.activo = activo;
		
	}

	// TODO: getters y setters
	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
     * Retorna true si el préstamo está activo y la fecha de vencimiento
     * es anterior a la fecha indicada.
     */
    public boolean estaVencido(LocalDate hoy) {//este metodo se maneja con dos condiciones
        // TODO: implementar
    	boolean estavencido = activo && fechaVencimiento.isBefore(hoy);//pregunta si el prestamo de dicho libro sigue activo
        return estavencido;											   // y pregunta si la fecha de vencimiento del libro prestado es anterior a la fecha de hoy
    }

	@Override
	public String toString() {
		return "Prestamo [socio=" + socio + ", libro=" + libro + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaVencimiento=" + fechaVencimiento + ", activo=" + activo + "]";
	}
}
