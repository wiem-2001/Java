public class Zoo {

    Animal[] animals;
    String name, city;
    final int NUMBER_OF_CAGES=25;

    int nbrAnimals;

    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[NUMBER_OF_CAGES];
        this.name = name;
        this.city = city;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages/Animals: " + NUMBER_OF_CAGES);
    }

    boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (nbrAnimals == NUMBER_OF_CAGES)
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
            animals[nbrAnimals] = null;
            this.nbrAnimals--;
        }
        return true;
    }

    void displayAnimals() {
        System.out.println("Liste des animaux de " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.name == animals[i].name)
                return i;
        }
        return index;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages/Animals: " + NUMBER_OF_CAGES;
    }
    public boolean isZooFull(Animal[] animals,int NUMBER_OF_CAGES)
    {
     if(animals!=null && NUMBER_OF_CAGES!=0)
     {
         return false;
     }
     else{
         return true;
     }
    }
    public Zoo comparerZoo(Zoo z1, Zoo z2)
    {
            if(z1.animals.length>z2.animals.length)
            {
                return z1;
            }
            else if (z2.animals.length>z1.animals.length)
            {
                return z2;
            }
            
    }
    
     boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }
}
