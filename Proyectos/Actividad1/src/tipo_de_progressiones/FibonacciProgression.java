package progressiones.tipos;

import progressiones.base.Progression;

public class FibonacciProgression extends Progression{

	protected long prev;
		
	public FibonacciProgression(long first,long second) {
		super(first);
		prev = second - first;
	}
	
	protected void advance() {
		long temp = prev;
		prev = current;
		current += temp;
	}
	
}
