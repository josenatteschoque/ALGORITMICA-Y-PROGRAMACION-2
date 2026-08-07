package biblioteca.interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import biblioteca.aplicacion.Constante;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;
import net.datastructures.LinkedPositionalList;
import net.datastructures.ProbeHashMap;

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

		while (!SC.hasNextInt()) { // Esta parte verifica que el numero ingresado por el usuario sea un numro y no
									// una palabra
			SC.next();
			mostrarError("Opcion invalida!. Ingrese un numero entre el 0 y 10: ");
		}

		// Retorna el numero ingresado por el usuario
		return SC.nextInt();
	}

	// Solicita al usuario que ingrese un isbn
	public static String pedirIsbn() {
		System.out.print("Ingrese ISBN: ");
		// TODO: implementar

		return SC.next(); // Retorna el isbn ingresado por el usuario
	}

	// Solicita al usuario que ingrese un nrodesocio
	public static String pedirNroSocio() {
		System.out.print("Ingrese número de socio: ");
		// TODO: implementar

		return SC.next(); // Retorna el nro de socio ingresado por el usuario
	}

	public static String pedirTitulo() {
		System.out.print("Ingrese título (o parte del título): "); // Solicita al usuario que ingrese un título o parte
																	// de un título
		// TODO: implementar

		SC.nextLine(); // Limpia el buffer antes de leer para evitar problemas con el nextInt anterior
		return SC.nextLine(); // Usa nextline para permitir espacios en el texto ingresado
	}

	public static String pedirAutor() {
		System.out.print("Ingrese nombre del autor: "); // Solicita al usuario que ingrese el nombre del autor
		// TODO: implementar

		SC.nextLine(); // Limpia el buffer antes de leer para evitar problemas con el nextInt anterior
		return SC.nextLine(); // Usa nextline para permitir espacios en el texto ingresado
	}

	public static int pedirN() {
		System.out.print("Ingrese cantidad de libros a mostrar: ");
		// TODO: implementar

		while (!SC.hasNextInt()) { // Verifica que el valor ingresado por el usuario sea un numero si no lo es
									// vuelve a repetir
			SC.next(); // Limpia el buffer
			mostrarError("valor invalido ingrese un numero:");
		}

		// Retorna el numero ingresado por el usuario
		return SC.nextInt();
	}

	/**
	 * Solicita una fecha al usuario en formato dd/MM/yyyy y la retorna como
	 * LocalDate. Debe validar el formato antes de retornar.
	 */
	public static LocalDate pedirFecha(String etiqueta) {
		while (true) {
			System.out.print("Ingrese " + etiqueta + " (dd/MM/yyyy): ");
			// TODO: implementar y validar formato usando DateTimeFormatter FMT

			String entrada = SC.next();
			try {

				return LocalDate.parse(entrada, FMT); // Valida el formato antes de retornarlo adentro de un try catch
														// para atrapar la excepcion y no detener el programa

				// Si es incorrecto avisa y vuelve a repetirse hasta que el usuario ingrese una
				// fecha valida
			} catch (DateTimeParseException e) {
				mostrarError("Formato de fecha invalido. Utilize dd/MM/yyyy");
			}
		}
	}

	// ── Métodos de presentación de resultados ──

	public static void mostrarLibro(Libro libro) {
		// TODO: implementar

		if (libro == null) { // Verifico si se encuetra dicho libro
			mostrarError("libro no encontrado");
			return;
		}

		// Si el libro se encontro muestro todas las partes del libro que la conforman
		System.out.println("---------------------------------------");
		System.out.println("Isbn: " + libro.getIsbn());
		System.out.println("Titulo: " + libro.getTitulo());
		System.out.println("Autor: " + libro.getAutor());
		System.out.println("Genero: " + libro.getGenero());
		System.out.println("Año de publicacion: " + libro.getAnioPublicacion());
		System.out.println("Copias disponibles: " + libro.getEjemplaresDisponibles());

		System.out.println("---------------------------------------");
	}

	public static void mostrarListaLibros(Iterable<Libro> libros) {
		// TODO: implementar
		boolean haylibros = false;

		if (libros == null) {
			mostrarMensaje("La lista esta vacia!");
			return;
		}

		for (Libro libro : libros) {
			mostrarLibro(libro); // Muestro los dichos libro con el metodo mostrarlibro
			haylibros = true; // Asigno true ya que se encontraron libros
		}

		if (!haylibros) { // Pregunto si se encontraro libros si la respuesta es false entra dentro del if
			mostrarMensaje("no se encontraron libros");
		}
	}

	public static void mostrarListaPrestamos(Iterable<Prestamo> prestamos) {
		// TODO: implementar
		boolean hayprestamos = false; // Con esta variable nos fijamos si el socio llego a tener prestamos

		for (Prestamo p : prestamos) { // Imprimo los disintos atributos de cada prestamo
			System.out.println("---------------------------------------");
			System.out.println("Socio: " + p.getSocio().getNroSocio() + " Nombre: " + p.getSocio().getNombre() + " "
					+ p.getSocio().getApellido());
			System.out.println("Libro: " + p.getLibro().getTitulo() + " Isbn: " + p.getLibro().getIsbn());
			System.out.println("Fecha Prestamo: " + p.getFechaPrestamo().format(FMT)); // El format(FMT) me imprime la
																						// fecha guardada en el formato
																						// que utilizo dd/MM/yyyy
			System.out.println("Fecha Vencimiento: " + p.getFechaVencimiento().format(FMT));
			System.out.println("Activo: " + p.isActivo());
			System.out.println("---------------------------------------");
			hayprestamos = true; // Luego asignamos true ala vaiable hay prestamos cosa que nos indica que hubo
									// almenos un prestamo
		}
		if (!hayprestamos) { // Esta condicion solo se cumple cuando el socio no tiene prestamos
			mostrarMensaje("no hay prestamos");
		}
	}

	//este metodo recibe la lista de libros de rankig ya ordenado y el mapa de contadores
	public static void mostrarRanking(LinkedPositionalList<Libro> libros, ProbeHashMap<String, Integer> conteo) {
		int posicion = 1;//establesco la pocicion de dicho libro en el ranking
		for (Libro libro : libros) {//con el for recorro toda la lista del ranking recuperando los libros
			System.out.println("---------------------------------------");
			System.out.println("puesto N°" + posicion);//esto imprime el puesto del libro en el ranking
			System.out.println("titulo: " + libro.getTitulo());// el titulo del libro
			System.out.println("autor: " + libro.getAutor());//el autor del libro
			System.out.println("veces solicitado: " + conteo.get(libro.getIsbn()));//y con el isbn recuperoel contador de las veces que fue rentado el libro en el mapa de contadores 
			System.out.println("---------------------------------------");
			posicion++;
		}
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static void mostrarError(String mensaje) {
		System.err.println("ERROR: " + mensaje);
	}
}
