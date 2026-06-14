package biblioteca.datos;

import java.io.File;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import net.datastructures.ProbeHashMap;
import net.datastructures.LinkedPositionalList;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Socio;
import biblioteca.modelo.Prestamo;

import java.time.format.DateTimeFormatter;	//Necesario para formatear la fecha

public class Dato {

    /**
     * Carga los libros desde un archivo de texto.
     * Formato de cada línea: isbn;titulo;autor;genero;anio;ejemplares
     * Ejemplo: 978-0;Cien años de soledad;García Márquez;Novela;1967;3
     *
     * @return mapa indexado por ISBN
     */
    public static ProbeHashMap<String, Libro> cargarLibros(String fileName)
            throws FileNotFoundException {

        ProbeHashMap<String, Libro> libros = new ProbeHashMap<>();
        
        // TODO: implementar lectura del archivo y carga del mapa
        Scanner lectura = new Scanner(new File(fileName));
        
        //Leera hasta la ultima linea del archivo
        while(lectura.hasNextLine()) {
        	
        	//Carga la primer linea del archivo
        	String linea = lectura.nextLine();
        	String[] datos = linea.split(";");
        	
        	//trim() Elimina espacios en blanco al principio y final de un String.
         	String isbn = datos[0].trim();
        	String titulo = datos[1].trim();
        	String autor = datos[2].trim();
        	String genero = datos[3].trim();
        	int anio = Integer.parseInt(datos[4].trim());
        	int ejemplares = Integer.parseInt(datos[5].trim());
        	
        	Libro libro = new Libro(isbn, titulo, autor, genero, anio, ejemplares);
        	
        	libros.put(isbn, libro);
        	
        }
        //Cierra el Scanner
    	lectura.close();

        return libros;
    }

    /**
     * Carga los socios desde un archivo de texto.
     * Formato de cada línea: nroSocio;nombre;apellido;email;activo
     * Ejemplo: S001;Juan;Perez;juan@mail.com;true
     *
     * @return mapa indexado por nroSocio
     */
    public static ProbeHashMap<String, Socio> cargarSocios(String fileName)
            throws FileNotFoundException {

        ProbeHashMap<String, Socio> socios = new ProbeHashMap<>();
        // TODO: implementar lectura del archivo y carga del mapa
        Scanner lectura = new Scanner(new File(fileName));
        
        //Leera hasta la ultima linea del archivo
        while(lectura.hasNextLine()){
        	String linea = lectura.nextLine();
        	String[] datos = linea.split(";");
        	
        	String nroSocio = datos[0].trim();
        	String nombre = datos[1].trim();
        	String apellido = datos[2].trim();
        	String email = datos[3].trim();
        	boolean activo = Boolean.parseBoolean(datos[4].trim());
        	
        	
        	Socio socio = new Socio(nroSocio, nombre, apellido, email, activo); 
        	
        	socios.put(nroSocio, socio);
        	
        }
        
        //Finaliza el Scanner
        lectura.close();
        return socios;
    }

    /**
     * Carga los préstamos activos desde un archivo de texto.
     * Formato de cada línea: nroSocio;isbn;fechaPrestamo;fechaVencimiento
     * Ejemplo: S001;978-0;01/06/2026;15/06/2026
     *
     * @return mapa indexado por nroSocio con la lista de préstamos de cada socio
     */
    public static ProbeHashMap<String, LinkedPositionalList<Prestamo>> cargarPrestamos(
            String fileName,
            ProbeHashMap<String, Socio> socios,
            ProbeHashMap<String, Libro> libros)
            throws FileNotFoundException {

        ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamos = new ProbeHashMap<>();
        // TODO: implementar lectura del archivo y carga del mapa
        Scanner lectura = new Scanner(new File(fileName));

        //Esto sirve para formatear las fechas 
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Leera hasta la ultima linea del archivo
        while(lectura.hasNextLine()) {
        	String linea = lectura.nextLine();
        	String[] datos = linea.split(";");

        			
        	String nroSocio = datos[0].trim();
        	String isbn = datos[1].trim();
        	LocalDate fechaPrestamo = LocalDate.parse(datos[2].trim(), formatter);
        	LocalDate fechaVencimiento = LocalDate.parse(datos[3].trim(), formatter);
        	
        	Socio socio = socios.get(nroSocio);	//Busca en el mapa de socios
        	Libro libro = libros.get(isbn);	//Busca en el mapa de libros
        	
        	if(socio != null && libro != null) {
        		//Si el socio y el libro estan en el mapa se crea un prestamo
        		
        		Prestamo p = new Prestamo(socio, libro, fechaPrestamo, fechaVencimiento); 
        		
        		//Vemos que si el prestamo esta en el mapa
        		LinkedPositionalList<Prestamo> lista = prestamos.get(nroSocio);
        		
        		//Si no esta se crea una nueva lista y se agrega al mapa
        		if(lista == null) {
        			lista = new LinkedPositionalList<>();
        			
        			prestamos.put(nroSocio, lista);
        		}

        		//Se agrega el prestamos ala lista
        		lista.addLast(p);
        	}
        }
        
        //Finaliza el Scanner
        lectura.close();
        return prestamos;
    }
}
