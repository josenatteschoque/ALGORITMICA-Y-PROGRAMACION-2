package biblioteca.aplicacion;

import java.io.IOException;
//import java.time.LocalDate;

import net.datastructures.LinkedPositionalList;
import net.datastructures.ProbeHashMap;
import biblioteca.datos.CargarParametros;
import biblioteca.datos.Dato;
import biblioteca.interfaz.Interfaz;
import biblioteca.logica.Logica;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Socio;

//import net.datastructures.LinkedQueue;

public class Aplicacion {

    public static void main(String[] args) {
        // 1. Cargar parámetros de configuración
        try {
            CargarParametros.parametros();
        } catch (IOException e) {
            System.err.println("Error al cargar config.properties");
            System.exit(-1);
        }

        // 2. Cargar datos desde archivos
        ProbeHashMap<String, Libro>   catalogo  = null;
        ProbeHashMap<String, Socio>   socios    = null;
        ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamos = null;
        

        try {
            catalogo  = Dato.cargarLibros(CargarParametros.getArchivoLibros());
            socios    = Dato.cargarSocios(CargarParametros.getArchivoSocios());
            prestamos = Dato.cargarPrestamos(CargarParametros.getArchivoPrestamos(),
                                             socios, catalogo);
        } catch (Exception e) {
            System.err.println("Error al cargar archivos de datos: " + e.getMessage());
            System.exit(-1);
        }

        // 3. Inicializar capa lógica
        Logica logica = new Logica(catalogo, socios, prestamos);

        // 4. Ciclo principal de la aplicación
        int opcion;
        do {
            opcion = Interfaz.menu();

            switch (opcion) {
                case Constante.OPCION_PRESTAR:
                    // TODO: pedir datos al usuario y llamar a logica.prestar(...)
                	String P_nrosocio = Interfaz.pedirNroSocio(); 	//Creo una variable nro de socio y lo cargo pidiendo ala clasee interfaz el metodo pedir nrosocio
                	String P_isbn = Interfaz.pedirIsbn(); 	//Creo la variable para almacenar el isbn y lo cargo piendole ala clase interfaz el metodo pedir isbn

                	Libro l = logica.buscarPorIsbn(P_isbn);
                	//Si el libro no esta muestra un mensaje de error
                	if(l == null) {
                		Interfaz.mostrarError("Libro no encontrado!");
                	//Si esta me fijo que tenga ejemplares disponibles
                	}else if(l.getEjemplaresDisponibles() > 0) {
                		//Realizo el prestamo
                    	boolean prestamoExitoso = logica.prestar(P_nrosocio, P_isbn);
                		if(prestamoExitoso == true) {	//Verifico si el socio esta en condiciones para dicho prestamo del libro
                    		Interfaz.mostrarMensaje("Prestamo registrado correctamente!");	//Accedo al metodo mostrar mensaje que esta en la clase interfaz para enviar y mostrar dicho mensaje
                    	}else {
                    		Interfaz.mostrarError("No se pudo registrar el prestamo!");// accedo al metodo mostrar error que esta en la clase interfaz para pasar el mensaje de error
                    	}
                	}else {
                		//Si no hay ejemplares agrego al socio ala cola de espera 
                		logica.agregarEspera(P_nrosocio, P_isbn);
                	}
                    break;

                case Constante.OPCION_DEVOLVER:
                    // TODO: pedir datos al usuario y llamar a logica.devolver(...)
                	String D_nrosocio = Interfaz.pedirNroSocio();	//Guarda el numero de socio pedido de de la clase Interfaz
                	String D_isbn = Interfaz.pedirIsbn();	//Guarda el isbn pedido de la clase interfaz
                	boolean devolverExitoso = logica.devolver(D_nrosocio, D_isbn);
                	if(devolverExitoso == true ) {	//consulta si es posible la devolucion
                		Interfaz.mostrarMensaje("Devolucion registrada correctamente!");	//Muestra el mensaje mandando al metodo mostrar mensaje de la clase interfaz
                	}else {
                		Interfaz.mostrarError("No se pudo completar la devolucion!");	//Muestra el mensaje enciado al metodo mostrar error de la clase interfaz
                	}
                    break;

                case Constante.OPCION_BUSCAR_ISBN:
                    // TODO: pedir ISBN y mostrar resultado de logica.buscarPorIsbn(...)
                	String B_isbn = Interfaz.pedirIsbn(); //Pedimos y almacenamos el isbn pedido
                	Libro libroEncontrado = logica.buscarPorIsbn(B_isbn);	//Buscamos el libro con el isbn con el metodo buscarporisbn de la clase interfaz
                	if(libroEncontrado != null) {
                    	Interfaz.mostrarLibro(libroEncontrado);	//Con el metodo mostrarlibro de la clase interfaz mostramos la caracteristicas del libro
                	}else {
                		Interfaz.mostrarError("Nose encontro ningun libro con isbn "+libroEncontrado);
                	}
                    break;

                case Constante.OPCION_BUSCAR_TITULO:
                    // TODO: pedir título y mostrar resultados de logica.buscarPorTitulo(...)
                	String B_titulo = Interfaz.pedirTitulo();	//Guardamos el titulo del libro pedido
                	LinkedPositionalList<Libro> listaTitulo = logica.buscarPorTitulo(B_titulo);
                	if(listaTitulo.isEmpty()) {
                		Interfaz.mostrarMensaje("No se encontraron libros con ese titulo.");
                	}else {
                    	Interfaz.mostrarListaLibros(listaTitulo);	//Con el metodo mostrarlistalibros mostramos todos lo libros buscado por el metodo buscarpor titulo de la clase logica que pueden contener ese titulo 
                	}
                    break;

                case Constante.OPCION_BUSCAR_AUTOR:
                    // TODO: pedir autor y mostrar resultados de logica.buscarPorAutor(...)
                	String B_autor = Interfaz.pedirAutor();	//Guardamos el nombre del autor
                	LinkedPositionalList<Libro> librosAutor = logica.buscarPorAutor(B_autor);
                	if(librosAutor.isEmpty()) {
                		Interfaz.mostrarMensaje("No se encontraron libros con ese autor.");
                	}else {
                    	Interfaz.mostrarListaLibros(librosAutor);	//Mostramos la lista de libros que este creados por el mismo autor 
                	}
                    break;

                case Constante.OPCION_DISPONIBLES:
                    // TODO: mostrar resultado de logica.listarDisponibles()
                	LinkedPositionalList<Libro> disponibles = logica.listarDisponibles();
                	if(disponibles.isEmpty()) {
                		Interfaz.mostrarMensaje("No hay libros disponibles!");
                	}else {
                		Interfaz.mostrarMensaje("Libros disponibles: ");
                    	Interfaz.mostrarListaLibros(disponibles);	//Con el metodo mostrarlistalibros de la clase interfaz mostramos los libros disponibles
                	}
                    break;

                case Constante.OPCION_PRESTAMOS_SOCIO:
                    // TODO: pedir nroSocio y mostrar logica.prestamosActivosDeSocio(...)
                	String P_S_nrosocio = Interfaz.pedirNroSocio();	//Guardamos el numero del socio
                	LinkedPositionalList<Prestamo> prestamosActivos = logica.prestamosActivosDeSocio(P_S_nrosocio);
                	if(prestamosActivos.isEmpty()) {
                		Interfaz.mostrarMensaje("No se encontraron prestamos activos!");
                	}else {
                		Interfaz.mostrarMensaje("Prestamos activo del socio "+P_S_nrosocio+":");
                    	Interfaz.mostrarListaPrestamos(prestamosActivos);	//Mostramos la lista de libros prestados al socio
                	}
                    break;

                case Constante.OPCION_HISTORIAL:
                    // TODO: pedir nroSocio y mostrar logica.historialDeSocio(...)
                	String nroSocio = Interfaz.pedirNroSocio();
                	//Cargo la lista con el historial del socio
                	LinkedPositionalList<Prestamo> historial = logica.historialDeSocio(nroSocio);
                	//Si la lista esta  vacia no tiene historial
                	if(historial.isEmpty()) {
                    	Interfaz.mostrarMensaje("No tiene historial!");
                	}else {
                		//Si tiene historial muestro la lista
                		Interfaz.mostrarMensaje("Historial del socio: "+nroSocio);
                		Interfaz.mostrarListaPrestamos(historial);
                	}
                	
                    break;

                case Constante.OPCION_RANKING:
                    // TODO: pedir N y mostrar logica.librosMasSolicitados(N)
                	  int n = Interfaz.pedirN();//pido la cantidad de libros en el top mostrados
                	  logica.librosMasSolicitados(n);
                	    
                    break;

                case Constante.OPCION_VENCIDOS:
                    // TODO: pedir fecha con Interfaz.pedirFecha(...) y mostrar
                    //       logica.prestamosVencidos(LocalDate)
                	String fecha = "Fecha: ";
                	LinkedPositionalList<Prestamo> vencidos= logica.prestamosVencidos(Interfaz.pedirFecha(fecha));
                	//Veo si la lista esta vacia
                	if(vencidos.isEmpty()) {
                		Interfaz.mostrarMensaje("No hay prestamos vencidos!");
                	}else {	//Si la lista no esta vacia entonces muestro la lista 
                		Interfaz.mostrarMensaje("Prestamos vencidos: ");
                		Interfaz.mostrarListaPrestamos(vencidos);
                	}
                    break;

                case Constante.OPCION_SALIR:
                    Interfaz.mostrarMensaje("Hasta luego.");
                    break;

                default:
                    Interfaz.mostrarError("Opción no válida.");
            }

        } while (opcion != Constante.OPCION_SALIR);
    }
}
