package progressiones.tipos;

import progressiones.base.Progression;

public class ArithmeticProgression extends Progression{
	
	protected long increment;
	
	public ArithmeticProgression(long stepsize, long start) {
		super(start);
		increment = stepsize;
	}
	
	protected void advance() {
		current += increment;
	}
}