package hospital;

import java.util.Objects;

public class Turno {
	private String fecha;
	private String  hora;
	private Paciente paciente;
	private Medico medico;
	
	
	//Constructor
	public Turno(String fecha, String hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
	}
	
	//Getters y Setters
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	//Equals y Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora);
	}

	//ToString
	@Override
	public String toString() {
		return "Turno [fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
	
}
