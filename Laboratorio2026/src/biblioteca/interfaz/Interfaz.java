package biblioteca.interfaz;

import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import biblioteca.aplicacion.Constante;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Prestamo;

public class Interfaz {

    private static final Scanner           SC  = new Scanner(System.in);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Muestra el menú principal y retorna la opción elegida por el usuario.
     */
    public static int menu() {
        System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
        System.out.println(Constante.OPCION_PRESTAR       + ". Registrar préstamo");
        System.out.println(Constante.OPCION_DEVOLVER      + ". Registrar devolución");
        System.out.println(Constante.OPCION_BUSCAR_ISBN   + ". Buscar libro por ISBN");
        System.out.println(Constante.OPCION_BUSCAR_TITULO + ". Buscar libro por título");
        System.out.println(Constante.OPCION_BUSCAR_AUTOR  + ". Buscar libro por autor");
        System.out.println(Constante.OPCION_DISPONIBLES   + ". Listar libros disponibles");
        System.out.println(Constante.OPCION_PRESTAMOS_SOCIO + ". Ver préstamos activos de un socio");
        System.out.println("---- Incremento 2 ----");
        System.out.println(Constante.OPCION_HISTORIAL     + ". Ver historial de un socio");
        System.out.println(Constante.OPCION_RANKING       + ". Libros más solicitados");
        System.out.println(Constante.OPCION_VENCIDOS      + ". Préstamos vencidos");
        System.out.println(Constante.OPCION_SALIR         + ". Salir");
        System.out.print("Ingrese una opción: ");

        // TODO: validar que la entrada sea un número dentro del rango válido

        //Valida si el dato ingresado es un entero y si no termina 
        while(!SC.hasNextInt()){
        	
        	//Limpia el buffer
        	SC.next();
        	
    		mostrarError("Opcion invalida!. Ingrese un numero entre el 0 y 10: ");
        }
        
        //Devuelve el numero ingresado
        return SC.nextInt();
    }
    

    public static String pedirIsbn() {
        System.out.print("Ingrese ISBN: ");
        // TODO: implementar
        return SC.next();	//Retorna el isbn
    }
    

    public static String pedirNroSocio() {
        System.out.print("Ingrese número de socio: ");
        // TODO: implementar
        return SC.next(); //Retorna el nroSocio
    }
    

    public static String pedirTitulo() {
        System.out.print("Ingrese título (o parte del título): ");
        // TODO: implementar
        return SC.next();
    }
    

    public static String pedirAutor() {
        System.out.print("Ingrese nombre del autor: ");
        // TODO: implementar
        return SC.next();
    }
    

    public static int pedirN() {
        System.out.print("Ingrese cantidad de libros a mostrar: ");
        // TODO: implementar
        //Valida si el dato ingresado es un entero si no termina 
        while(!SC.hasNextInt()) {	
        	
        	//Tomo el valor ingresado
        	SC.nextInt();
        		
    		mostrarError("Ingrese un numero positivo! ");
        }
        //Devuelvo el valor ingresado
    	return SC.nextInt();
    }

    /**
     * Solicita una fecha al usuario en formato dd/MM/yyyy y la retorna
     * como LocalDate. Debe validar el formato antes de retornar.
     */
    public static LocalDate pedirFecha(String etiqueta) {
        System.out.print("Ingrese " + etiqueta + " (dd/MM/yyyy): ");
        // TODO: implementar y validar formato usando DateTimeFormatter FMT
        while(true) {
        	String fechaStr = SC.nextLine().trim();
        	
        	try {
        		LocalDate fecha = LocalDate.parse(fechaStr, FMT);
            	return fecha;
            	
        	}catch(DateTimeParseException e){
        		mostrarError("Formato de fecha invalido. Utilize dd/MM/yyyy");
        	}
        		
        }
        
    }

    // ── Métodos de presentación de resultados ──

    public static void mostrarLibro(Libro libro) {
        // TODO: implementar
    	if(libro == null) {
    		System.out.println("Libro no encontrado!");
    		return;
    	}
    	
    	System.out.println("ISBN: "+libro.getIsbn());
    	System.out.println("TITULO: "+libro.getTitulo());
    	System.out.println("AUTOR: "+libro.getAutor());
    	System.out.println("GENERO: "+libro.getGenero());
    	System.out.println("AÑO DE PUBLICACION: "+libro.getAnioPublicacion());
    	System.out.println("COPIASx DISPONIBLES: "+libro.getEjemplaresDisponibles());
    	
    }

    public static void mostrarListaLibros(Iterable<Libro> libros) {
        // TODO: implementar
    	if(libros == null) {
        	System.out.println("La lista de libros es nula!");
        	return;
    	}
    	
    	int contador = 0;
    	
    	//Recorro la lista
    	for(Libro l: libros) {
    		if(l != null) {
            	System.out.println((++contador)+". "+"Titulo: "+l.getTitulo()+" Autor: "+l.getAutor()+" Isbn: "+l.getIsbn());
            	System.out.println("Ejemplares Disponibles: "+l.getEjemplaresDisponibles());
    		}
    	}
    	
    	if(contador == 0) {
        	System.out.println("No se encontraron libros!. ");
    	}
    }

    public static void mostrarListaPrestamos(Iterable<Prestamo> prestamos) {
        // TODO: implementar
    	if(prestamos == null) {
        	System.out.println("La lista de prestamos es nula! ");
        	return;
    	}
    	int contador = 0;
    	for(Prestamo p: prestamos) {
    		if(p != null && p.isActivo()) {
            	System.out.println("Prestamo: "+contador++);
            	System.out.println("Socio: "+p.getSocio().getNroSocio()+" Nombre: "+p.getSocio().getNombre()+" "+p.getSocio().getApellido());
            	System.out.println("Libro"+p.getLibro().getTitulo()+" Isbn: "+p.getLibro().getIsbn());
            	
            	System.out.println("Fecha Prestamo: "+p.getFechaPrestamo().format(FMT));
            	System.out.println("Fecha Vencimiento: "+p.getFechaVencimiento().format(FMT));
            	if(p.isActivo() == true) {
            		System.out.println("Estado: Activo");
            	}else {
            		System.out.println("Estado: Devuelto");
            	}
    		}
    	}
    	
    	if(contador == 0) {
            System.out.println("No hay préstamos activos para mostrar.");
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
}
