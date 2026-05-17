package potencia;

public class PotenciaRecursiva {

	//Metodo que calcula la potencia de forma recursiva
	public static long CalcularPotencia(int base, int exponente) throws IllegalArgumentException {
		if(exponente < 0 ) {
			throw new IllegalArgumentException("El exponente tiene que ser positivo!");
		}
		//Caso base
		if(exponente == 0) {
			return 1;
		}
		//Caso Recursivo
		return base * CalcularPotencia(base ,exponente -1);
		
	}
	
	
	//Metodo que calcula la potencia dependiendo del exponente 
	public static long PotenciaOptimizada(int base, int exponente) throws IllegalArgumentException {
		if(exponente < 0 ) {
			throw new IllegalArgumentException("El exponente tiene que ser positivo!");
		}
		//Caso base
		if(exponente == 0) {
			return 1;
		}
		//Si el exponente es par!
		if(exponente % 2 == 0) {
			long parcial = PotenciaOptimizada(base, exponente/2);
			return parcial * parcial;
			//Si el exponente es impar!
		}else{
			//Caso normal
			return base * PotenciaOptimizada(base, exponente-1);
		}
		//Si el exponente es par: a^n = (a^(n/2))^2
		//Si el exponente es impar: a^n = a × a^(n-1)
		
	}

}
