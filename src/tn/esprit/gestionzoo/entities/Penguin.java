package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatiques{

    private float swimmingDepth;

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingDepth:" + swimmingDepth;
    }
    public float getSwimmingDepth()
    {
        return this.swimmingDepth;
    }
    public void swim() {
        super.swim();
        System.out.println("This Penguin is swimming.");
       }
}
