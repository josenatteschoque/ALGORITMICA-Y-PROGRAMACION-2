package complejo;

public class Complejo {
	//Tributos pribvados
	private double real;
	private double imaginario;
	
	//Constructor: sirve para darle vida y valores iniciales alas vaiables que definimos arriba.
	public Complejo(double real, double imaginario){
		this.real = real;
		this.imaginario = imaginario;
	}
	
	//Realiza la operacion suma de complejos a+b.i = (a + b.i) + (c + d.i) =(a + c)+ (b + d).i
	public Complejo sumar(Complejo otro) {
		return new Complejo(this.real + otro.real, this.imaginario + otro.imaginario);
	}
	
	//Realiza la operacion resta de complejos (a + b.i) - (c + d.i) =(a - c)+ (b - d).i
	public Complejo restar(Complejo otro) {
		return new Complejo(this.real - otro.real, this.imaginario - otro.imaginario);
	}
	
	public Complejo producto(Complejo otro) {
		return new Complejo(this.real*otro.real, this.imaginario*otro.imaginario);
	}
}


