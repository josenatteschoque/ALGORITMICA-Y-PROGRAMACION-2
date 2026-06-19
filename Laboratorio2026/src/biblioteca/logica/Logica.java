package biblioteca.logica;

import java.time.LocalDate;

import net.datastructures.ProbeHashMap;
import net.datastructures.LinkedPositionalList;
import net.datastructures.LinkedQueue;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Socio;
import biblioteca.modelo.Prestamo;

public class Logica {

    private ProbeHashMap<String, Libro> catalogo;	//Mapa isbn, Libro
    private ProbeHashMap<String, Socio> socios;		//Mapa nroSocio, Socio
    
    private ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamoActivos;	//Mapa nroSocio, Lista de prestamos activos
    
    // TODO: definir las estructuras adicionales que necesite
    // Pensar: ¿dónde guardar los préstamos activos?
    // Pensar: ¿cómo modelar la lista de espera por libro?
    // Pensar: ¿dónde guardar el historial de préstamos por socio?

    public Logica(ProbeHashMap<String, Libro> catalogo,
                  ProbeHashMap<String, Socio> socios,
                  ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamosActivos) {
        this.catalogo = catalogo;
        this.socios   = socios;
        
        this.prestamoActivos= prestamosActivos;	//Guardo en el mapa los prestamosActivos
        
        // TODO: inicializar las estructuras internas a partir de los datos recibidos
    }

    // ── INCREMENTO 1 ──────────────────────────────────────────────

    /**
     * Registra el préstamo de un libro a un socio.
     * La fecha de préstamo es la fecha actual y el vencimiento se calcula
     * automáticamente (14 días).
     * Condiciones: el socio debe estar activo y debe haber ejemplares disponibles.
     * @return true si el préstamo se realizó, false en caso contrario
     */
    public boolean prestar(String nroSocio, String isbn) {
        // TODO: implementar
    	//Busca el socio y libro en sus mapas
    	Socio socio = socios.get(nroSocio);
		Libro libro = catalogo.get(isbn);
		
		//Valido si existen 
    	if(socio == null || libro == null) {
    		
    		//Si no existe retorna false
    		return false;
    	}
    	
    	//Veo si el socio esta activo si no retorna false
    	if(socio.isActivo() == false) {
    		return false;
    	}
    	
    	//Si no hay ejemplares disponibles nose puede prestar 
    	if(libro.getEjemplaresDisponibles() <= 0) {
    		return false;
    	}
    	
    	//Calculo la fecha
    	LocalDate fechaPrestamo = LocalDate.now();	//Obtiene la fecha actual del sistema
    	LocalDate fechaVencimiento = fechaPrestamo.plusDays(14);	//Suma 14 dias despues de la fecha del prestamo
    	
    	//Creo el prestamo y lo pongo en true porque se pudo prestar!
    	Prestamo p = new Prestamo(socio, libro, fechaPrestamo, fechaVencimiento, true);
    	
    	//Reduzco la cantidad de ejemplares disponibles
    	libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() -1);
    	
    	LinkedPositionalList<Prestamo> lista = prestamoActivos.get(nroSocio);
    	//Si la lista esta vacia creo una nueva
    	if(lista == null) {
    		
    		lista = new LinkedPositionalList<>();
    		//Cargo el nroSocio y la lista de prestamos
    		prestamoActivos.put(nroSocio, lista);
    	}
    	
    	//Cargo la lista de prestamos
    	lista.addLast(p);
    	
    	//Se pudo realizar el prestamo del libro!
    	return true;
    	
    }

    /**
     * Registra la devolución de un libro.
     * Actualiza el estado del préstamo y la disponibilidad del libro.
     * @return true si la devolución se realizó, false en caso contrario
     */
    public boolean devolver(String nroSocio, String isbn) {
        // TODO: implementar
    	Libro libro = catalogo.get(isbn);
    	Socio socio = socios.get(nroSocio);
    	
    	//Si no existen alguno de ellos no puede devolver 
    	if(socio == null || libro == null) {
    		return false;
    	}
    	
    	//Lista de prestamos del socio
    	LinkedPositionalList<Prestamo> lista = prestamoActivos.get(nroSocio);
    	if(lista == null) {
    		return false;
    	}
    	
    	Prestamo prestamoEncontrado = null;
    	
    	//Busca el prestamo activo
    	for(Prestamo p: lista) {
    		//Veo si el prestamo coincida con el isbn y que este activo
    		if(p.getLibro().getIsbn().equals(isbn) && p.isActivo()) {
    			prestamoEncontrado = p;
    			break;	//Salgo cuando lo encuentro
    		}
    	}
    	
    	//Si no hay un prestamo nose puede devolver
    	if(prestamoEncontrado == null) {
    		return false;
    	}
    	
    	//Marco como devuelto
    	prestamoEncontrado.setActivo(false);
    	
  
    	//Se aumenta la cantidad de ejemplares disponibles
    	libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() + 1);
    	
    	//Se pudo devolver correctamente
        return true;
    }

    /**
     * Busca un libro por su ISBN.
     * @return el Libro encontrado, o null si no existe
     */
    public Libro buscarPorIsbn(String isbn) {
        // TODO: implementar
        return catalogo.get(isbn);
    }

    /**
     * Busca libros cuyo título contenga la cadena indicada (sin distinguir mayúsculas).
     */
    public LinkedPositionalList<Libro> buscarPorTitulo(String titulo) {
        // TODO: implementar
    	LinkedPositionalList<Libro> resultado = new LinkedPositionalList<>();
    	
    	//Convierto la busqueda a minusculas y elimino espacios 
    	String busquedad = titulo.toLowerCase().trim();
    	
    	//Recorro todos los libros del catalogo
    	for(Libro libro: catalogo.values()) {
    		
    		//Si el titulo contiene el texto buscado lo agrego ala lista
    		if(libro.getTitulo().toLowerCase().contains(busquedad)) {
    			resultado.addLast(libro);
    		}
    	}
    	//Retorna la lista
        return resultado;
    }

    /**
     * Busca libros de un autor dado (sin distinguir mayúsculas).
     */
    public LinkedPositionalList<Libro> buscarPorAutor(String autor) {
        // TODO: implementar
    	LinkedPositionalList<Libro> resultado = new LinkedPositionalList<>();
    	
    	//Convierto la busqueda a minusculas y elimino espacios 
    	String busquedad = autor.toLowerCase().trim();
    	
    	//Recorro todos los libros del catalogo
    	for(Libro libro: catalogo.values()) {
    		
    		//Si el autor contiene el texto buscado lo agrego ala lista
    		if(libro.getAutor().toLowerCase().contains(busquedad)) {
    			resultado.addLast(libro);
    		}
    	}
    	//Reotorna la lista
        return resultado;
    }

    /**
     * Retorna todos los libros con al menos un ejemplar disponible.
     */
    public LinkedPositionalList<Libro> listarDisponibles() {
        // TODO: implementar
    	LinkedPositionalList<Libro> disponibles = new LinkedPositionalList<>();
    	
    	//Recorre todos los libros del catalogo
    	for(Libro libro: catalogo.values()) {
    	
    		//Si hay ejemplares disponibles se agragan
    		if(libro.getEjemplaresDisponibles() > 0) {
    			disponibles.addLast(libro);
    		}
    	}
    	
    	//Retorna la lista
        return disponibles;
    }

    /**
     * Retorna los préstamos activos de un socio.
     */
    public LinkedPositionalList<Prestamo> prestamosActivosDeSocio(String nroSocio) {
        // TODO: implementar
    	LinkedPositionalList<Prestamo> activos = new LinkedPositionalList<>();

    	//Si no hay la lista retorna la lista vacia
    	LinkedPositionalList<Prestamo> lista = prestamoActivos.get(nroSocio);
    	if(lista == null) {
    		return activos;
    	}
    	
    	//Recorre la lista y solo agrega los que estan activos
    	for(Prestamo p: lista) {
    		if(p.isActivo() == true) {
    			activos.addLast(p);
    		}
    	}
    	
    	//Retorna la lista
        return activos;
    }

    // ── INCREMENTO 2 ──────────────────────────────────────────────

    /**
     * Agrega un socio a la cola de espera de un libro.
     * Se invoca cuando no hay ejemplares disponibles al momento del pedido.
     */
    public void agregarEspera(String nroSocio, String isbn) {
        // TODO: implementar
    }

    /**
     * Al devolver un libro, si hay socios en espera, asigna el ejemplar
     * automáticamente al primero en la cola y lo notifica.
     */
    public void asignarSiguienteEnEspera(String isbn) {
        // TODO: implementar
    }

    /**
     * Retorna el historial completo de préstamos de un socio
     * (activos e históricos), en orden cronológico.
     */
    public LinkedPositionalList<Prestamo> historialDeSocio(String nroSocio) {
        // TODO: implementar
        return null;
    }

    /**
     * Retorna los N libros más solicitados (préstamos activos + históricos).
     * @param n cantidad de libros a retornar
     */
    public LinkedPositionalList<Libro> librosMasSolicitados(int n) {
        // TODO: implementar
        return null;
    }

    /**
     * Retorna todos los préstamos cuya fecha de vencimiento expiró
     * y que aún no fueron devueltos.
     * @param hoy fecha actual
     */
    public LinkedPositionalList<Prestamo> prestamosVencidos(LocalDate hoy) {
        // TODO: implementar
        return null;
    }
}
