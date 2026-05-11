package base_progression;

public abstract class  Progression {
	
	//Instancia de variable
	protected long current;
	
	//Constructor Progression que inicializa en cero
	public Progression() { this(0); }

	//Constructor
	public Progression(long start) { current = start; }
	
	//Retorna el siguente valor de Progression
	public long nextValue() {
		long answer = current;
		advance();
		return answer;
	}
	
	protected abstract void advance();
}