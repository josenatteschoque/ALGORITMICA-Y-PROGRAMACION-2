package progressiones.tipos;

import progressiones.base.Progression;

public class GeometricProgression extends Progression{

	protected long base;
		
	public GeometricProgression(long b, long start) {
		super(start);
		base = b;
	}
	
	protected void advance() {
		current *= base;
	}
	
}
