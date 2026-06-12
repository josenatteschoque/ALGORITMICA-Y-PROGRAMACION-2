package biblioteca.datos;
import java.io.FileNotFoundException;

import biblioteca.datos.Dato; 
import net.datastructures.ProbeHashMap;
import biblioteca.modelo.Libro;

public class TestCargaDatos {
	public static void main(String[] args) {
		
		try {
			ProbeHashMap<String, Libro> libros = Dato.cargarLibros("src/libros.txt");
			System.out.println("Libros cargados: " +libros.size());
			
			//Muestra los libros cargados
			for(String isbn: libros.keySet()) {
				Libro l = libros.get(isbn);
                System.out.println(isbn + " - " + l.getTitulo() + " - " + l.getAutor());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
