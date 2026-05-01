package figura;


public class PruebaRectangulo {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		Rectangulo rect=new Rectangulo(new Punto(2, 3), 4, 5);
        Rectangulo copia=(Rectangulo)rect.clone();
		
        System.out.println("rect�ngulo "+ rect);
        System.out.println("copia "+ copia);	
        
        if (rect == copia)
			System.out.println("Direcciones iguales");
		else
			System.out.println("Direcciones distintas");

		if (rect.getOrigen()==(copia.getOrigen()))
			System.out.println("Punto origen iguales");
		else
			System.out.println("Punto origen distintos");
	}
	
	
}
