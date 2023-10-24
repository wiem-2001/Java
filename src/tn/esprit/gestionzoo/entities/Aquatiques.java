package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public class Aquatiques extends Animal{
    private String habitat ;

    public Aquatiques(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat:" + habitat;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aquatiques aquatiques = (Aquatiques) o;
        return age == aquatiques.age &&
                Objects.equals(name, aquatiques.name) &&
                Objects.equals(habitat, aquatiques.habitat);
    }
    public void swim()
    {
        System.out.println("This aquatic animal is swimming.");
    }
}
