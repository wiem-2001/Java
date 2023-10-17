package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatiques{
 private float swimmingSpeed  ;

 public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
  super(family, name, age, isMammal, habitat);
  this.swimmingSpeed = swimmingSpeed;
 }

 @Override
 public String toString() {
  return "Dolphin{" +
          "swimmingSpeed=" + swimmingSpeed +
          ", family='" + family + '\'' +
          ", name='" + name + '\'' +
          ", age=" + age +
          ", isMammal=" + isMammal +
          '}';
 }

 @Override
 public void swim() {
  super.swim();
  System.out.println("This dolphin is swimming.");
 }
}
