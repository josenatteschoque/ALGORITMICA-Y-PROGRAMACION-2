/*Vamos a crear un carácter de clase con un campo: nombre . 
 * Después de eso, creamos dos objetos de la clase Character , character1 y character2 y 
 * les asignamos el mismo nombre. Si usamos el hashCode() y equals() predeterminados de la clase Object,
 *  definitivamente obtendremos objetos diferentes, no iguales. Así es como funciona el código hash en
 *   Java. Tendrán diferentes códigos hash porque están en diferentes celdas de memoria y el resultado
 *    de la operación equals() será falso. */
package prueba;
import java.util.Objects;

public class Character {
    private String Name;

    public Character(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static void main(String[] args) {
        Character character1 = new Character("Arnold");
        System.out.println(character1.getName());
        System.out.println(character1.hashCode());
        Character character2 = new Character("Arnold");
        System.out.println(character2.getName());
        System.out.println(character2.hashCode());
        System.out.println(character2.equals(character1));
    }
}