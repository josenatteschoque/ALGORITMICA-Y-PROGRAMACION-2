package prueba;

import java.util.Objects;

public class Character2 {
    private String Name;

    public Character2(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;

        Character character = (Character) o;

        return getName() != null ? getName().equals(character.getName()) : character.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
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