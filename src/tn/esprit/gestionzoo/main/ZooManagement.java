package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {

    public static void main(String[] args) {
        Animal lion = new Animal();
        lion.name = "Simba";
        lion.age = 8;
        lion.family = "Cats";
        lion.isMammal = true;

        Zoo myZoo = new Zoo("Wildlife Park", "Ariana");
        Zoo notMyZoo = new Zoo("WaterPark", "Siliana");


        Animal dog = new Animal("Canine", "Snoopy", 2, true);


        try { myZoo.addAnimal(lion);
        myZoo.addAnimal(dog);
     }catch (InvalidAgeException e) {
        System.out.println("Erreur : " + e.getMessage());
    }
        catch(ZooFullException e)
    {
        System.out.println("Erreur : "+e.getMessage());
    }
        myZoo.displayAnimals();

        System.out.println(myZoo.searchAnimal(dog));
        Animal dog2 = new Animal("Canine", "lll", 2, true);
        System.out.println(myZoo.searchAnimal(dog2));

        //   System.out.println(myZoo.removeAnimal(dog));
        myZoo.displayAnimals();


        System.out.println(myZoo);

        try { myZoo.addAnimal(lion);
        myZoo.addAnimal(dog);
        myZoo.addAnimal(dog2);
        }catch (InvalidAgeException e) {
        System.out.println("Erreur : " + e.getMessage());
    }
        catch(ZooFullException e)
        {
            System.out.println("Erreur : "+e.getMessage());
        }
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(lion));
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(dog2));
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(dog));
        myZoo.displayAnimals();

//        System.out.println(Zoo.comparerZoo(myZoo, notMyZoo));
//        System.out.println(myZoo.isZooFull());

        Aquatiques aq=new Aquatiques("Canine", "Snoopy", 2, true,"doghouse");
        Dolphin d=new Dolphin("Delphinidae", "dolphin", 2, true,"Coastal Waters",32 );
        Penguin p=new Penguin("Penguins", "Emperor Penguin", 2, true,"Antarctica",457);
        Terrestrial terrestrial = new Terrestrial("Panda", "Narla", 4, true, 2);
       
        System.out.println(aq.toString());
        System.out.println(d.toString());
        System.out.println(p.toString());
        
        aq.swim();
        d.swim();
        p.swim();
       
       try {
           myZoo.addAnimal(aq);
           myZoo.addAquaticAnimal(d);
           myZoo.addAquaticAnimal(p);
       }catch (InvalidAgeException e) {
           System.out.println("Erreur : " + e.getMessage());
       }catch(ZooFullException e)
       {
           System.out.println("Erreur : "+e.getMessage());
       }
    }
    

}
