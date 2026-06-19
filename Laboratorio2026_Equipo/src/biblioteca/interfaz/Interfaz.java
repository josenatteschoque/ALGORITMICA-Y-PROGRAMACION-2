package biblioteca.interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import biblioteca.aplicacion.Constante;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;

public class Interfaz {

	private static final Scanner SC = new Scanner(System.in);
	private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Muestra el menú principal y retorna la opción elegida por el usuario.
	 */
	public static int menu() {
		System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
		System.out.println(Constante.OPCION_PRESTAR + ". Registrar préstamo");
		System.out.println(Constante.OPCION_DEVOLVER + ". Registrar devolución");
		System.out.println(Constante.OPCION_BUSCAR_ISBN + ". Buscar libro por ISBN");
		System.out.println(Constante.OPCION_BUSCAR_TITULO + ". Buscar libro por título");
		System.out.println(Constante.OPCION_BUSCAR_AUTOR + ". Buscar libro por autor");
		System.out.println(Constante.OPCION_DISPONIBLES + ". Listar libros disponibles");
		System.out.println(Constante.OPCION_PRESTAMOS_SOCIO + ". Ver préstamos activos de un socio");
		System.out.println("---- Incremento 2 ----");
		System.out.println(Constante.OPCION_HISTORIAL + ". Ver historial de un socio");
		System.out.println(Constante.OPCION_RANKING + ". Libros más solicitados");
		System.out.println(Constante.OPCION_VENCIDOS + ". Préstamos vencidos");
		System.out.println(Constante.OPCION_SALIR + ". Salir");
		System.out.print("Ingrese una opción: ");

		// TODO: validar que la entrada sea un número dentro del rango válido
		while (!SC.hasNextInt()) {//esta parte verifica que el numero ingresado por el usuario sea un numro y no una palabra
			SC.next();
			System.out.println("opcion invalida ingrese el numero:");
		}
		return SC.nextInt();//retorna el numero ingresado por el usuario
	}
// solicita al usuario que ingrese un isbn
	public static String pedirIsbn() {
		System.out.print("Ingrese ISBN: ");
		// TODO: implementar
		return SC.next();//retorna el isbn ingresado por el usuario
	}
//solicita al usuario que ingrese un nrodesocio
	public static String pedirNroSocio() {
		System.out.print("Ingrese número de socio: ");
		// TODO: implementar
		return SC.next();//retorna el nro de socio ingresado por el usuario
	}
	  
	public static String pedirTitulo() {
		System.out.print("Ingrese título (o parte del título): "); //solicita al usuario que ingrese un título o parte de un título
		// TODO: implementar
		SC.nextLine();      //limpia el buffer antes de leer para evitar problemas con el nextInt anterior
		return SC.nextLine();//usa nextline para permitir espacios en el texto ingresado
	}

	public static String pedirAutor() {
		System.out.print("Ingrese nombre del autor: ");//solicita al usuario que ingrese el nombre del autor
		// TODO: implementar
		SC.nextLine();//limpia el buffer antes de leer para evitar problemas con el nextInt anterior
		return SC.nextLine();//usa nextline para permitir espacios en el texto ingresado
		}

	public static int pedirN() {
		System.out.print("Ingrese cantidad de libros a mostrar: ");
		// TODO: implementar
		while (!SC.hasNextInt()) {//verifica que el valor ingreasado por el usuario sea un numero si no lo es vuelve a repetir
			SC.next();//limpia el buffer 
			System.out.println("valor invalido ingrese un numero:");
		}
		return SC.nextInt();//retorna el numero ingresado por el usuario
	}

	/**
	 * Solicita una fecha al usuario en formato dd/MM/yyyy y la retorna como
	 * LocalDate. Debe validar el formato antes de retornar.
	 */
	public static LocalDate pedirFecha(String etiqueta) {
		while (true) {
			System.out.print("Ingrese " + etiqueta + " (dd/MM/yyyy): ");//solicita al usuario que ingrese una fecha en formato dd/MM/yyyy
			// TODO: implementar y validar formato usando DateTimeFormatter FMT
			String entrada = SC.next();
			try {
				return LocalDate.parse(entrada, FMT); //valida el formato antes de retornarlo adentro de un try carch para atrapar la axepcion y no detener el programa
				//si es incorrecto avisa y vuelve a repetirse hasta que el usuario ingrese una fecha valida
			} catch (DateTimeParseException e) {
				System.out.println("formato invalido use dd/MM/yyyy");
			}
		}
	}

	// ── Métodos de presentación de resultados ──

	public static void mostrarLibro(Libro libro) {
		// TODO: implementar
		if(libro == null) {//verifico si se encuetra dicho libro
			System.out.println("libro no encntrado");
			return;
		}
		//si el libro se encontro muestro todas las partes del libro que la conforman
		System.out.println("---------------------------------------");
		System.out.println("isbn:"+libro.getIsbn());
		System.out.println("titulo:"+libro.getTitulo());
		System.out.println("autor:"+libro.getAutor());
		System.out.println("genero:"+libro.getGenero());
		System.out.println("año de publicacion:"+libro.getAnioPublicacion());
		System.out.println("copias disponibles:"+libro.getEjemplaresDisponibles());
		System.out.println("---------------------------------------");
	}

	public static void mostrarListaLibros(Iterable<Libro> libros) {
		// TODO: implementar
		boolean haylibros = false;
		for(Libro libro: libros) {
			mostrarLibro(libro); //muestro los dichos libro con el metodo mostrarlibro
			haylibros = true; //asigno true ya que se aencontrado libros
		}
		if(!haylibros) {//pregunto si se encontraro libros si la respuesta es false entra dentro del if
			System.out.println("no se encontraron libros");
		}
	}

	public static void mostrarListaPrestamos(Iterable<Prestamo> prestamos) {
		// TODO: implementar
		boolean hayprestamos = false;//con esta variable nos fijamos si el socio llego a tener prestamos
		for(Prestamo p: prestamos) {//imprimo los disintos atributos de cada prestamo
			System.out.println("---------------------------------------");
			System.out.println("socio:"+p.getSocio().getNroSocio());
			System.out.println("libro:"+p.getLibro().getTitulo());
			System.out.println("prestado:"+ p.getFechaPrestamo().format(FMT));//el .format(FMT) me imprime la fecha guardada en el formato que utilizo dd/MM/yyyy
			System.out.println("vence:"+p.getFechaVencimiento().format(FMT));
			System.out.println("activo:"+p.isActivo());
			System.out.println("---------------------------------------");
			hayprestamos=true;// luego asignamos true ala vaiable hayprestamos cosa que nos indica que hubo almenos un prestamo
		}
		if(!hayprestamos) {//esta condicion solo se cumple cuando el socio no tiene prestamos
			System.out.println("no hay prestamos");
		}
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static void mostrarError(String mensaje) {
		System.err.println("ERROR: " + mensaje);
	}
}
