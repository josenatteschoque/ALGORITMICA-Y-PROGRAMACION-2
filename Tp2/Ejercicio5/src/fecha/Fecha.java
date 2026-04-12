package fecha;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	//Constructor
	public Fecha(int dia, int mes, int anio) {
		if(esValida(dia, mes, anio)) {
			this.dia = dia;
			this.mes = mes;
			this.anio = anio;
		}else {
			this.dia = 1;
			this.mes = 1;
			this.anio = 2024;
		}
	}
	
	//Bisiesto: Un año es bisiesto si es divisible por 4, pero no por 100, a menos que sea divisible por 400.
	private boolean esBifiesto(int anio) {
		return(anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0); 
	}
	
	private int diasDelmes(int mes, int anio) {
		switch (mes) {
		case 4: case 6: case 9: case 11: return 30;	//Son los meses en los cuales tiene 30 dias!
		case 2: return esBifiesto(anio) ? 29 : 28;	//condición ? valor_si_es_verdadero : valor_si_es_falso;
		default: return 31;
		}
	}
	
	private boolean esValida(int d, int m, int a) {
		return(m > 1 && m <= 12) && (d >= 1 && d <= diasDelmes(m, a));
	}
	
	public void diaSiguiente() {
		dia++;
		if(dia > diasDelmes(mes, anio)) {
			dia = 1;
			mes++;
			if(mes > 12) {
				mes = 1;
				anio++;
			}
		}
	}
	
	public void diaAnterior() {
		dia--;	//Restamos el dia
		if(dia < 1){
			mes--;	//Retrocedemos al mes anterior
			
			if(mes < 1) {
				mes = 12;
				anio--;	//Retrocedemos de anio
			}
		//El dia debe de ser el ultimo del nueno mes
		dia = diasDelmes(mes, anio);
		}	
	}
	
	//Metodo que verifica que fecha es mayor
	public int Comparar(Fecha otro) {
		//Comparo los años
		if(this.anio > otro.anio) return 1;
		if(this.anio < otro.anio) return -1;

		//Comparo los meses
		if(this.mes > otro.mes) return 1;
		if(this.mes > otro.mes) return -1;
		
		//Comparo los dias
		if(this.dia > otro.dia) return 1;
		if(this.dia < otro.dia) return -1;
		
		//Si son iguales
		return 0;
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", anio=" + anio + "]";
	}	
}
