package fibonacci;

public class FibonacciRecursiva {

	// Metodo Fibonacci Recursivo
	public static long FibonacciRecursiva(int n) {
		// Caso base N = 0
		if (n == 0) {
			return 0;
		}
		// Caso base N = 1
		if (n == 1) {
			return 1;
		}
		// Caso Recursivo
		return FibonacciRecursiva(n - 1) + FibonacciRecursiva(n - 2);
	}

	/*
	 * Fórmula de Binet (la cuenta directa) Esta fórmula usa el número áureo (phi,
	 * que es aproximadamente 1.618) y la raíz cuadrada de 5.
	 * 
	 * La fórmula es: F(n) = (φⁿ - ψⁿ) / √5
	 * 
	 * Donde:
	 * 
	 * φ (phi) = (1 + √5) / 2 ≈ 1.618034
	 * 
	 * ψ (psi) = (1 - √5) / 2 ≈ -0.618034
	 */
	
	public static long FibonacciOptimizado(int n) {
		//Calcula la raiza de 5
		double raiz5 = Math.sqrt(5);
		
		//Calcula los numeros
		double phi = (1 + raiz5) / 2 ;
		double psi = (1 - raiz5) / 2;
		
		//Calcula la Formula de Binet
		double resul = (Math.pow(phi, n) - Math.pow(psi, n)) / raiz5;
	
		//Math.round(resul); se encarga de redondear el resultado
		return Math.round(resul);
		
		//Tuve que usar IA ya que no podia hacer las cuentas...
	}
}
