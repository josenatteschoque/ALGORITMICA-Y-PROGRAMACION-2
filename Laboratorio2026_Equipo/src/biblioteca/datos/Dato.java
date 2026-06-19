package biblioteca.datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import net.datastructures.ProbeHashMap;
import net.datastructures.LinkedPositionalList;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Socio;
import biblioteca.modelo.Prestamo;

public class Dato {

	/**
	 * Carga los libros desde un archivo de texto. Formato de cada línea:
	 * isbn;titulo;autor;genero;anio;ejemplares Ejemplo: 978-0;Cien años de
	 * soledad;García Márquez;Novela;1967;3
	 *
	 * @return mapa indexado por ISBN
	 */
	public static ProbeHashMap<String, Libro> cargarLibros(String fileName) throws FileNotFoundException {

		ProbeHashMap<String, Libro> libros = new ProbeHashMap<>();
		// TODO: implementar lectura del archivo y carga del mapa
		Scanner lectura = new Scanner(new File(fileName));
		while (lectura.hasNextLine()) {
			String linea = lectura.nextLine();
			String[] partes_del_libro = linea.split(";");

			Libro libro = new Libro(
					  partes_del_libro[0]
					, partes_del_libro[1]
					, partes_del_libro[2]
					, partes_del_libro[3]
					,Integer.parseInt(partes_del_libro[4])
					, Integer.parseInt(partes_del_libro[5]));
			libros.put(partes_del_libro[0], libro);
		}
		lectura.close();
		return libros;
	}

	/**
	 * Carga los socios desde un archivo de texto. Formato de cada línea:
	 * nroSocio;nombre;apellido;email;activo Ejemplo:
	 * S001;Juan;Perez;juan@mail.com;true
	 *
	 * @return mapa indexado por nroSocio
	 */
	public static ProbeHashMap<String, Socio> cargarSocios(String fileName) throws FileNotFoundException {

		ProbeHashMap<String, Socio> socios = new ProbeHashMap<>();
		// TODO: implementar lectura del archivo y carga del mapa
		Scanner lectura = new Scanner(new File(fileName));
		while (lectura.hasNextLine()) {
			String linea = lectura.nextLine();
			String[] p_socios = linea.split(";");

			Socio socio = new Socio(p_socios[0] // pues
					, p_socios[1] //
					, p_socios[2] //
					, p_socios[3] //
					, Boolean.parseBoolean(p_socios[4]) //
			);

			socios.put(p_socios[0], socio);
		}
		lectura.close();
		return socios;
	}

	/**
	 * Carga los préstamos activos desde un archivo de texto. Formato de cada línea:
	 * nroSocio;isbn;fechaPrestamo;fechaVencimiento Ejemplo:
	 * S001;978-0;01/06/2026;15/06/2026
	 *
	 * @return mapa indexado por nroSocio con la lista de préstamos de cada socio
	 */
	public static ProbeHashMap<String, LinkedPositionalList<Prestamo>> cargarPrestamos(String fileName,
			ProbeHashMap<String, Socio> socios, ProbeHashMap<String, Libro> libros) throws FileNotFoundException {

		ProbeHashMap<String, LinkedPositionalList<Prestamo>> prestamos = new ProbeHashMap<>();
		// TODO: implementar lectura del archivo y carga del mapa
		Scanner lectura = new Scanner(new File(fileName));
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		while (lectura.hasNextLine()) {
			String linea = lectura.nextLine();
			String[] partes = linea.split(";");

			String nrosocio = partes[0];
			String isbn = partes[1];
			LocalDate fechaprestamo = LocalDate.parse(partes[2], formato);
			LocalDate fechavencimiento = LocalDate.parse(partes[3], formato);

			Socio socio = socios.get(nrosocio);
			Libro libro = libros.get(isbn);

			Prestamo prestamo = new Prestamo(socio, libro, fechaprestamo, fechavencimiento, true);
			LinkedPositionalList<Prestamo> lista = prestamos.get(nrosocio);
			if (lista == null) {
				lista = new LinkedPositionalList<>();
				prestamos.put(nrosocio, lista);
			}
			lista.addLast(prestamo);

		}
		lectura.close();

		return prestamos;
	}
}
