package biblioteca.logica;

import java.time.LocalDate;

import net.datastructures.ProbeHashMap;
import net.datastructures.HeapPriorityQueue;
import net.datastructures.LinkedPositionalList;
import net.datastructures.LinkedQueue;
import biblioteca.aplicacion.Constante;
import biblioteca.interfaz.Interfaz;
//import biblioteca.interfaz.Interfaz;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Socio;
import biblioteca.modelo.Prestamo;

public class Logica {

	private ProbeHashMap<String, Libro> catalogo;
	private ProbeHashMap<String, Socio> socios;

	// TODO: definir las estructuras adicionales que necesite

	// Pensar: ¿dónde guardar los préstamos activos?
	private ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamosActivo;// Creamos un nuevo mapa para guardar
																					// la lista de prestamos de los socios
	
	// Pensar: ¿cómo modelar la lista de espera por libro?
	private ProbeHashMap<String, LinkedQueue<String>> colaDeEspera = new ProbeHashMap<>(); // Creo la cola de espera

	// Pensar: ¿dónde guardar el historial de préstamos por socio?
	private ProbeHashMap<String, LinkedPositionalList<Prestamo>> historialSocio = new ProbeHashMap<>();
	
	// Mapa que uso para guardar el contador de cada libro como llave se usa el isbn
	// del libro prestado
	private ProbeHashMap<String, Integer> conteo = new ProbeHashMap<>();

	// ==================================================
	public Logica(ProbeHashMap<String, Libro> catalogo, ProbeHashMap<String, Socio> socios,
			ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamosActivos) {
		// TODO: inicializar las estructuras internas a partir de los datos recibidos
		this.catalogo = catalogo;
		this.socios = socios;
		this.prestamosActivo = prestamosActivos;

		// Esto me sirve para inicializar los prestamos del archivo prestamos ya que sin
		// Esto solo me contaria los prestamos dados despues de ejecutar el programa
		for (LinkedPositionalList<Prestamo> lista : prestamosActivos.values()) { // Cargamos las listamos de prestamos
																					// de los socios almacenados en el
																					// mapa
			for (Prestamo p : lista) {// exploramos prestamo por prestamo de dicha lista
				String isbn = p.getLibro().getIsbn();// asignamos el isbn del libro prestado
				Integer cant = conteo.get(isbn);// asignamos del mapa el valor del contador
				if (cant == null) {// si el contaodr no exite osea que ese libro no fue prestado antes
					conteo.put(isbn, 1);// se le carga al mapa como primera ves que se presta
				} else {// si el libro ya estaba dentro del mapa lo que se hace es actualizar la
						// cantidad de veces que fue prestado el libro
					conteo.put(isbn, cant + 1);
				}
			}
		}

	}

	// ── INCREMENTO 1 ──────────────────────────────────────────────

	/**
	 * Registra el préstamo de un libro a un socio. La fecha de préstamo es la fecha
	 * actual y el vencimiento se calcula automáticamente (14 días). Condiciones: el
	 * socio debe estar activo y debe haber ejemplares disponibles.
	 * 
	 * @return true si el préstamo se realizó, false en caso contrario
	 */
	public boolean prestar(String nroSocio, String isbn) {
		// TODO: implementar
		Socio socio = socios.get(nroSocio);// Busco al socio con el nro de socio
		Libro libro = catalogo.get(isbn);// Busco el libro con el isbn

		// Verifico que el socio y libro existan
		if (socio == null || libro == null) {
			// Si no existen retorna false
			return false;
		}

		// Verifico que el socio este activo
		if (socio.isActivo() == false) {
			return false;
		}

		// Si no hay ejemplares disponibles nose puede prestar
		if (libro.getEjemplaresDisponibles() <= 0) {
			// Lo agrego ala cola de espera
			agregarEspera(nroSocio, isbn);
			return false;
		}

		// Calculo la fecha
		LocalDate fechaprestamo = LocalDate.now();// Creo y guardo la fecha que se le fue prestado el libro
		//Modifique el valor 14 fijo por una constante.
		LocalDate fechadevencimiento = fechaprestamo.plusDays(Constante.FECHA_VENCIMIENTO);// Con el metodo plusDays le sumo 14 dias ala fecha
																	// del prestamo asi tenemos la fecha de vencimiento

		// Creo el prestamo
		Prestamo prestamo = new Prestamo(socio, libro, fechaprestamo, fechadevencimiento, true);// Creamos un nuevo
																								// prestamo con dichos
																								// datos y true por que
																								// el prestamo esta
																								// activo

		LinkedPositionalList<Prestamo> lista_de_prestamos = prestamosActivo.get(nroSocio);// Llamamos ala lista de
																							// prestamos del socio

		// Preguntamos si tiene una lista de prestamos
		if (lista_de_prestamos == null) {
			lista_de_prestamos = new LinkedPositionalList<>(); // Si no es asi le creamos una nueva lista de prestamos
			prestamosActivo.put(nroSocio, lista_de_prestamos); // cargamos la lista de prestamos al mapa de
																// prestamosActivos como kays usamos el nro del socio
		}

		lista_de_prestamos.addLast(prestamo); // Añadimos el nuevo prestamo al final de la lista de prestamos del socio
		libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() - 1);// actualizamos la cantidad de ejemplares
																				// que estan disponibes de dicho libro

		// Se pudo realizar el prestamo
		Integer cant = conteo.get(isbn);// asignamos el contador que estaba en el mapa guardado por el isbn
		if (cant == null) {// si no existe el contador para ese libro lo agragamos al mapa y ya que esto se
							// hace luego de un prestamo lo ceteamos como que fue prestado una ves
			conteo.put(isbn, 1);
		} else {// si ya existia dicho contador dentro del mapa solo lo actualizo ya que ese
				// ejemplar de libro fue nebamente rentado
			conteo.put(isbn, cant + 1);
		}
		// retorna true ya que el prestamo se pudo completar con exito
		return true;
	}

	/**
	 * Registra la devolución de un libro. Actualiza el estado del préstamo y la
	 * disponibilidad del libro.
	 * 
	 * @return true si la devolución se realizó, false en caso contrario
	 */
	public boolean devolver(String nroSocio, String isbn) {
		// TODO: implementar
		Libro libro = catalogo.get(isbn);
		Socio socio = socios.get(nroSocio);

		// Si no existen alguno de ellos no puede puede devolver
		if (socio == null || libro == null) {
			return false;
		}

		LinkedPositionalList<Prestamo> lista_de_prestamo = prestamosActivo.get(nroSocio); // Asignamos a
																							// lista_de_prestamos la
																							// listada de prestamos del
																							// socio guardado en el mapa
		if (lista_de_prestamo == null) { // Si no existe dicha lista retornamos false ya que no se pudo realizar dicha
											// operacion
			return false;
		}

		for (Prestamo p : lista_de_prestamo) { // Leemos la lista de prestamos del socio uno por uno
			if (p.getLibro().getIsbn().equals(isbn) && p.isActivo()) { // Preguntamos si es el libro que quiere devolver
																		// esta en dicha lista
				p.setActivo(false); // Si es asi desactivamos el prestamo como que ya lo a devuelto

				p.getLibro().setEjemplaresDisponibles(p.getLibro().getEjemplaresDisponibles() + 1);// Actualizamos la
																									// cantidad de
																									// ejemplares de
																									// dicho libro

				// Realizo el prestamo al primero de la cola
				asignarSiguienteEnEspera(isbn);
				// Retornamos true ya que la operacion se realizo con exito
				return true;
			}
		}

		// No se pudo devolver!
		return false;
	}

	/**
	 * Busca un libro por su ISBN.
	 * 
	 * @return el Libro encontrado, o null si no existe
	 */
	public Libro buscarPorIsbn(String isbn) {
		// TODO: implementar
		return catalogo.get(isbn); // Buscamos en el catalogo el libro con el keys isbn y lo retornamos
	}

	/**
	 * Busca libros cuyo título contenga la cadena indicada (sin distinguir
	 * mayúsculas).
	 */
	public LinkedPositionalList<Libro> buscarPorTitulo(String titulo) {
		// TODO: implementar
		LinkedPositionalList<Libro> resultados_de_busqueda = new LinkedPositionalList<>(); // Creo una nueva lista de
																							// resultado de busqueda
		for (Libro libro : catalogo.values()) { // Exploro el catalogo
			if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {// Vuelvo el titulo de libro en
																					// minuscula y pregunto si el titulo
																					// del libro del catalogo contiene
																					// parte del titulo ingresado por el
																					// usuario tambien convertido en
																					// minuscula
				resultados_de_busqueda.addLast(libro); // Si es asi añado ese libro al final de la lista de libros
														// encontrados
			}
		}
		// Retorno la lista de libro encontrados segun el titulo dado por el usuario
		return resultados_de_busqueda;
	}

	/**
	 * Busca libros de un autor dado (sin distinguir mayúsculas).
	 */
	public LinkedPositionalList<Libro> buscarPorAutor(String autor) {
		// TODO: implementar
		LinkedPositionalList<Libro> resultados_de_busqueda = new LinkedPositionalList<>(); // Creo una lista para la
																							// busqueda pr autor
		for (Libro libro : catalogo.values()) { // Exploro el catalogo uno por uno
			if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) { // Convierto el nombre del autor del
																				// libro en minuscula y consulto si
																				// contiene al autor tambien convertido
																				// en minuscula dado por el usuario
				resultados_de_busqueda.addLast(libro); // Guardo el libro al final de la lista
			}
		}
		// Retorno la lista de libros encontrados por el autor
		return resultados_de_busqueda;
	}

	/**
	 * Retorna todos los libros con al menos un ejemplar disponible.
	 */
	public LinkedPositionalList<Libro> listarDisponibles() {
		// TODO: implementar
		LinkedPositionalList<Libro> resultados_de_busqueda = new LinkedPositionalList<>(); // Creo una nueva lista para
																							// la busqueda

		for (Libro libro : catalogo.values()) { // Exploro el catalogo uno por uno

			if (libro.getEjemplaresDisponibles() > 0) { // Pregunto si quedan ejemplares del dicho libro inspecionado
				resultados_de_busqueda.addLast(libro); // Si es asi guardo el libro al final de la lista
			}
		}
		return resultados_de_busqueda; // Retorno la lista de libros con ejemplares disponibles
	}

	/**
	 * Retorna los préstamos activos de un socio.
	 */
	public LinkedPositionalList<Prestamo> prestamosActivosDeSocio(String nroSocio) {
		// TODO: implementar
		LinkedPositionalList<Prestamo> busca_prestamo = new LinkedPositionalList<>(); // Creo una neuva lista para
																						// guardar los prestamos activos
		LinkedPositionalList<Prestamo> lista_de_prestamos = prestamosActivo.get(nroSocio); // Creo y asigno a esta otra
																							// lista la lista de
																							// prestamos que tiene el
																							// socio en el mapa de
																							// prestamos activos

		if (lista_de_prestamos == null) { // Pregunta si existe la lista
			return busca_prestamo; // Si no es asi retorno la lista vacia
		}

		for (Prestamo p : lista_de_prestamos) { // Exploro la lista de prestamos uno por uno

			if (p.isActivo() == true) { // Pregunto si este prestamo esta activo
				busca_prestamo.addLast(p); // Si es haci añado el prestamo al final de la lista para los prestamos
											// activos
			}

		}
		return busca_prestamo; // Retorno la lista de prestamos activos de dicho socio
	}

	// ── INCREMENTO 2 ──────────────────────────────────────────────

	/**
	 * Agrega un socio a la cola de espera de un libro. Se invoca cuando no hay
	 * ejemplares disponibles al momento del pedido.
	 */
	public void agregarEspera(String nroSocio, String isbn) {
		// TODO: implementar
		LinkedQueue<String> colaEspera = colaDeEspera.get(isbn);

		if (colaEspera == null) {
			// Si la cola esta vacia la creo
			colaEspera = new LinkedQueue<>();
			// Cargo el mapa con el isbn y la cola
			colaDeEspera.put(isbn, colaEspera);
		}
		// Cargo la cola con el nroSocio
		colaEspera.enqueue(nroSocio);
		System.out.println("Socio " + nroSocio + " Anotado en la lista de espera!");
	}

	/**
	 * Al devolver un libro, si hay socios en espera, asigna el ejemplar
	 * automáticamente al primero en la cola y lo notifica.
	 */
	public void asignarSiguienteEnEspera(String isbn) {
		// TODO: implementar
		LinkedQueue<String> espera = colaDeEspera.get(isbn);
		if (espera == null) {
			return;
		}

		// Si la cola tiene socios asigno el ejemplar al primero en la cola
		while (!espera.isEmpty()) {// loop para verifica si el socio sele puede prestar osea que el socio este
									// activo
			// Obtengo el primero en la cola
			String nroSocio = espera.dequeue();
			// Veo si el prestamo se pudo hacer sino se repite hasta que un socio sea apto
			// para dicho prestamo del libro
			if (prestar(nroSocio, isbn) == true) {
				System.out.println("Prestamo asignado al socio " + nroSocio);
				// Termina el while ya que se le pudo prestar al socio correctamente
				return;
			}
		}

	}

	/**
	 * Retorna el historial completo de préstamos de un socio (activos e
	 * históricos), en orden cronológico.
	 */
	public LinkedPositionalList<Prestamo> historialDeSocio(String nroSocio) {
		// TODO: implementar
		LinkedPositionalList<Prestamo> historial = new LinkedPositionalList<>();
		LinkedPositionalList<Prestamo> lista_de_prestamos = prestamosActivo.get(nroSocio); // Creo y asigno a esta otra
																							// lista la lista de
																							// prestamos que tiene el
																							// socio en el mapa de
																							// prestamos activos
		if (lista_de_prestamos == null) {
			// Si la lista de prestamos esta vacia retorna la lista vacia
			return historial;
		}

		// Cargo el mapa con el nroSocio y su historial
		historialSocio.put(nroSocio, lista_de_prestamos);

		// Retorna el historial del socio
		return lista_de_prestamos;
	}

	/**
	 * Retorna los N libros más solicitados (préstamos activos + históricos).
	 * 
	 * @param n cantidad de libros a retornar
	 */
	public LinkedPositionalList<Libro> librosMasSolicitados(int n) {
		// TODO: implementar

		LinkedPositionalList<Libro> resultados = new LinkedPositionalList<>();

		// verifica que alla prestamos sino retorna una lista vacia
		if (conteo.isEmpty()) {
			System.out.println("No hay datos de prestamos.");
			return resultados;
		}

		HeapPriorityQueue<Integer, String> colavmenor = new HeapPriorityQueue<>();//crea una cola de prioridad para almacenar de menor a mayor
		for (String isbn : conteo.keySet()) {//cargo la llave del mapa conteo que seria el isbn
			colavmenor.insert(-conteo.get(isbn), isbn);//inserto ala cola el clave/valor negado del contaodr dentro del mapa (negaod para que el orden de la cola de prioridad sea de mayor a menor)
		}												//y tambien inserto en la cola el isbn
		
		//Modifique esto para el final!
		//Muestro el ranking de los libros mas solicitados mediante la interfaz
		resultados = Interfaz.rankingLibro(colavmenor, n, catalogo, conteo);

		return resultados;// retorno la lista
	}

	/**
	 * Retorna todos los préstamos cuya fecha de vencimiento expiró y que aún no
	 * fueron devueltos.
	 * 
	 * @param hoy fecha actual
	 */
	public LinkedPositionalList<Prestamo> prestamosVencidos(LocalDate hoy) {
		// TODO: implementar

		LinkedPositionalList<Prestamo> vencidos = new LinkedPositionalList<>();// lista vacia donde se van a guardar los
																				// prestamos los prestamos vencidos
																				// encontrados

		for (LinkedPositionalList<Prestamo> lista : prestamosActivo.values()) { // recorre todas las listas de prestamos
																				// de cada socio
			for (Prestamo p : lista) { // recorro los prestamos que esta dentro de cada lista de cada socio
				if (p.estaVencido(hoy)) { // uso el metodo ya implementado en modelo.Prestamo
					vencidos.addLast(p);// agrego el prestamo vencido al final de la lista
				}
			}
		}

		return vencidos;// retorna la lista de vencidos
	}

}
