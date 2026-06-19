package biblioteca.aplicacion;

import java.io.IOException;
import java.time.LocalDate;

import net.datastructures.LinkedPositionalList;
import net.datastructures.ProbeHashMap;
import biblioteca.datos.CargarParametros;
import biblioteca.datos.Dato;
import biblioteca.interfaz.Interfaz;
import biblioteca.logica.Logica;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Socio;

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
                	String P_nrosocio = Interfaz.pedirNroSocio(); // creo una variable nro de socio y lo cargo pidiendo ala clasee interfaz el metodo pedir nrosocio
                	String P_isbn = Interfaz.pedirIsbn(); // creo la variable para almacenar el isbn y lo cargo piendole ala clase interfaz el metodo pedir isbn
                	if(logica.prestar(P_nrosocio, P_isbn)) {//verifico si el socio esta en condiciones para dicho prestamo del libro
                		Interfaz.mostrarMensaje("prestamo registrado correctamente");// accedo al metodo mostrar mensaje que esta en la clase interfaz para enviar y mostrar dicho mensaje
                	}else {
                		Interfaz.mostrarError("no se pud registrar el prestamo\n "
                				+ "verifique que el socio este activo y alla ejemplares disponibles");// accedo al metodo mostrar error que esta en la clase interfaz para pasar el mensaje de error
                	}
                	
                    break;

                case Constante.OPCION_DEVOLVER:
                    // TODO: pedir datos al usuario y llamar a logica.devolver(...)
                	String D_nrosocio = Interfaz.pedirNroSocio();// guarda el numero de socio pedido de de la clase Interfaz
                	String D_isbn = Interfaz.pedirIsbn(); // guarda el isbn pedido de la clase interfaz
                	
                	if(logica.devolver(D_nrosocio, D_isbn)) {//consulta si es posible la debolucion
                		Interfaz.mostrarMensaje("debolucion registrada correctamente");// muestra el mensaje mandando al metodo mostrar mensaje de la clase interfaz
                	}else {
                		Interfaz.mostrarError("no se pudo completar la debolucion"); // muestra el mensaje enciado al metodo mostrar error de la clase interfaz
                	}
                    break;

                case Constante.OPCION_BUSCAR_ISBN:
                    // TODO: pedir ISBN y mostrar resultado de logica.buscarPorIsbn(...)
                	String Bisbn = Interfaz.pedirIsbn(); //pedimos y almacenamos el isbn pedido
                	Libro libro = logica.buscarPorIsbn(Bisbn);// buscamos el libro con el isbn con el metodo buscarporisbn de la clase interfaz
                	Interfaz.mostrarLibro(libro);//con el metodo mostrarlibro de la clase interfaz mostramos la caracteristicas del libro
                    break;

                case Constante.OPCION_BUSCAR_TITULO:
                    // TODO: pedir título y mostrar resultados de logica.buscarPorTitulo(...)
                	String T_titulo = Interfaz.pedirTitulo();//guardamos el titulo del libro pedido
                	Interfaz.mostrarListaLibros(logica.buscarPorTitulo(T_titulo));//con el metodo mostrarlistalibros mostramos todos lo libros buscado por el metodo buscarpor titulo de la clase logica que pueden contener ese titulo 
                    break;

                case Constante.OPCION_BUSCAR_AUTOR:
                    // TODO: pedir autor y mostrar resultados de logica.buscarPorAutor(...)
                	String B_autor = Interfaz.pedirAutor();//guardamos el nombre del autor
                	Interfaz.mostrarListaLibros(logica.buscarPorAutor(B_autor));//mostramos la lista de libros que este creados por el mismo autor 
                    break;

                case Constante.OPCION_DISPONIBLES:
                    // TODO: mostrar resultado de logica.listarDisponibles()
                	Interfaz.mostrarListaLibros(logica.listarDisponibles());//con el metodo mostrarlistalibros de la clase interfaz mostramos los libros disponibles
                    break;

                case Constante.OPCION_PRESTAMOS_SOCIO:
                    // TODO: pedir nroSocio y mostrar logica.prestamosActivosDeSocio(...)
                	String P_S_nrosocio = Interfaz.pedirNroSocio();//guardamos el numero del socio
                	Interfaz.mostrarListaPrestamos(logica.prestamosActivosDeSocio(P_S_nrosocio));//mostramos la lista de libros prestados al socio
                    break;

                case Constante.OPCION_HISTORIAL:
                    // TODO: pedir nroSocio y mostrar logica.historialDeSocio(...)
                	Interfaz.mostrarMensaje("opcion disponible proximamente en elincremento 2");
                    break;

                case Constante.OPCION_RANKING:
                    // TODO: pedir N y mostrar logica.librosMasSolicitados(N)
                	Interfaz.mostrarMensaje("opcion disponible proximamente en el incremento 2");
                    break;

                case Constante.OPCION_VENCIDOS:
                    // TODO: pedir fecha con Interfaz.pedirFecha(...) y mostrar
                    //       logica.prestamosVencidos(LocalDate)
                	Interfaz.mostrarMensaje("opcion disponible proximamente en el incremento 2");
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
