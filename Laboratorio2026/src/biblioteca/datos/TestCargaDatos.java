package biblioteca.datos;
import java.io.FileNotFoundException;


import biblioteca.datos.Dato;
import net.datastructures.LinkedPositionalList;
import net.datastructures.ProbeHashMap;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Socio;

public class TestCargaDatos {
	public static void main(String[] args) {
		
		//Carga los libros
		//Dejo esto afuera haci puedo usarlo en el prestamo
		ProbeHashMap<String, Libro> libros = null;
		try {
			libros = Dato.cargarLibros("src/libros.txt");
			System.out.println("Libros cargados: " +libros.size());
			
			//Muestra los libros cargados
			//Recorre todos los libros y devuelve todo el valor almacenado en el mapa
			for(Libro l: libros.values()) {
                System.out.println(l);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Carga los socios
		//Dejo esto afuera haci puedo usarlo en el prestamo
		ProbeHashMap<String, Socio> socios = null;
		try {
			socios = Dato.cargarSocios("src/socios.txt");
			System.out.println("Socios cargados: "+socios.size());
			
			//Muestro los socios cargados
			//Recorre todos los socios y devuelve todo el valor almacena en el mapa
			for(Socio s: socios.values()) {
				System.out.println(s);
			}

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Cargo los prestamos 
		try {
			ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamos =	Dato.cargarPrestamos("src/prestamos.txt", socios, libros);
			System.out.println("Prestamos cargados: "+prestamos.size());
			
			for(String nroSocio: prestamos.keySet()) {
				LinkedPositionalList<Prestamo> lista = prestamos.get(nroSocio);
				System.out.println("Socio: " + nroSocio + " (" + lista.size() + " préstamos)");
				
				/*for(Prestamo p : lista) {
					System.out.println("   → " + p);
				}*/
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
