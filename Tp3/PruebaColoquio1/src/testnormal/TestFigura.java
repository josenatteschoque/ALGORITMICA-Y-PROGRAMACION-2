package testnormal;

import figuras.Circulo;
import figuras.Figura;
import figuras.Punto;
import figuras.Rectangulo;

public class TestFigura {
	public static void main(String[] args) {
		Figura figuras[] = new Figura[6];
		
		figuras[0] = new Rectangulo(new Punto(10, 10), 3, 2);
		figuras[1] = new Circulo(new Punto(5, 5), 3);
		figuras[2] = new Circulo(new Punto(20, 10), 8);
		figuras[3] = new Circulo(new Punto(12, 10), 12);
		figuras[4] = new Rectangulo(new Punto(15, 3), 6, 6);
		figuras[5] = new Rectangulo(new Punto(20, 9), 6, 9);
	
		/*Assert.assertEquals(3 * 2, figuras[0].area(), 0.01);
		Assert.assertEquals(Math.PI * 3 * 3, figuras[1].area(), 0.01);
		Assert.assertEquals(Math.PI * 8 * 8, figuras[2].area(), 0.01);
		Assert.assertEquals(Math.PI * 12 * 12, figuras[3].area(), 0.01);
		Assert.assertEquals(6 * 6, figuras[4].area(), 0.01);
		Assert.assertEquals(6 * 9, figuras[5].area(), 0.01);*/
		//Creo que esta comparando si el resultado es correcto
		
		System.out.println("Area: "+figuras[0].area());
		System.out.println("Area: "+figuras[1].area());
		System.out.println("Area: "+figuras[2].area());
		System.out.println("Area: "+figuras[3].area());
		System.out.println("Area: "+figuras[4].area());
		System.out.println("Area: "+figuras[5].area());		
		
		
		
	}
}
