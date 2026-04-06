package progressiones.base;

public abstract class Progression {
	
	protected long current;


	public Progression(long start) { current = start; }
	
	
	public long nextValue() {
		long answer = current;
		advance();
		return answer;
	}
	
	//Metodo abstracto: Cada hijo debe decir como avazar
	protected abstract void advance();
	
	public void printProgression(int n) {
		System.out.print(nextValue());
		for(int j = 1;j < n;j++) 
			System.out.print(" " + nextValue());
		System.out.println();
	}
	
}