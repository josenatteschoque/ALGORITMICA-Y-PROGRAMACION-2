package tiempo;

public class Tiempo {
	private int horas;
	private int minutos;
	private int segundos;
	
	//Constructor
	public Tiempo(int horas, int minutos, int segundos) {
		this.horas = (horas >= 0  && horas < 24) ? horas : 0; //variable = (condición) ? valor_si_es_verdadero : valor_si_es_falso;
		this.minutos = (minutos >= 0 && minutos < 60) ? minutos : 0;
		this.segundos = (segundos >= 0 && segundos < 60) ? segundos : 0;
	}
	
	//Metodo para incrementar los segundos
	public void ingrementarSegundo() {
		this.segundos++;
		if(segundos == 60) {
			this.segundos = 0;
			incrementarMinuto();
		}
	}
	
	//Metodo para incrementar los minutos
	public void incrementarMinuto() {
		this.minutos++;
		if(minutos == 60) {
			this.minutos = 0;
			incrementarHora();
		}
	}
	
	//Metodo para incrementar las horas
	public void incrementarHora() {
		this.horas++;
		if(horas == 24) {
			this.horas = 0;
		}
	}
	
	//Metodo toString sirve para mostrar el resultado en este formato horas:minutos:segundos 
	public String toString() {
		return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}
}
