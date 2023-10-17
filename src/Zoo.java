public class Zoo {

    Animal[] animals;
    String city;
    private String name;
    final int nbrCages=25;

    int nbrAnimals;

    public Zoo() {
    }
  
  public void setName(String name)
  {
    if(name!=null)
    {
    this.name=name;
    }
    else{
        System.out.println("Le nom d’un Zoo ne doit pas être vide");
    }
  }
  public String getName()
  {
    return this.name;
  }
    public Zoo(String name, String city) {
        animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages);
    }

    boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        return isZooFull();
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
        return "Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages;
    }
    public boolean isZooFull(Animal[] animals)
    {
     if(animals.length==nbrCages)
     {
         return true;
     }
     else{
         return false;
     }
    }
    
    public Zoo comparerZoo(Zoo z1, Zoo z2)
    {
            if(z1.animals.length>z2.animals.length)
            {
                return z1;
            }
            else (z2.animals.length>z1.animals.length)
            {
                 return z2;
            }
            
    }
}
