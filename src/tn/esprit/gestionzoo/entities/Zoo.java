package tn.esprit.gestionzoo.entities;

public class Zoo {

    static final int NUMBER_OF_CAGES = 25;
    Animal[] animals;
    String name, city;
    int nbrAnimals;
    Aquatiques[] aquaticAnimals;
    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[NUMBER_OF_CAGES];
        this.name = name;
        this.aquaticAnimals=new Aquatiques [10];
        this.city = city;
    }

    static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals);
    }

   public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
            if (searchAnimal(animal) != -1)
                System.out.println("animal non trouvé");
            if(nbrAnimals<NUMBER_OF_CAGES)
            {
                if (animal.getAge() >= 0) {
                animals[nbrAnimals] = animal;
                nbrAnimals++;
                    System.out.println("Nombre d'animaux : " + nbrAnimals);
                } else {
                    throw new InvalidAgeException("L'âge de l'animal ne peut pas être négatif.");
                }
            }
       else {
           throw new ZooFullException("le zoo est plein");
            }

   }

    public boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals] = null;
        this.nbrAnimals--;
        return true;
    }

   public void displayAnimals() {
        System.out.println("List of animals of " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

   public int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.name == animals[i].name)
                return i;
        }
        return index;
    }

    boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals;
    }
    public void addAquaticAnimal(Aquatiques aquatic)
    {
        if(this.aquaticAnimals.length<10)
        {
            this.aquaticAnimals[this.aquaticAnimals.length]=aquatic;
        }
    }

    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;
    
        for (Aquatiques aquatic : aquaticAnimals) {
            if (aquatic != null) {
                if (aquatic instanceof Dolphin) {
                    dolphinCount++;
                } else if (aquatic instanceof Penguin) {
                    penguinCount++;
                }
            }
        }
    }
    public float maxPenguinSwimmingDepth()
    {
        float maxDepth = 0.0f;
        for (Aquatiques aquatic : aquaticAnimals) {
             if (aquatic instanceof Penguin) {
                Penguin penguin = (Penguin) aquatic;
                if(penguin.getSwimmingDepth()> maxDepth)
                {
                    maxDepth=penguin.getSwimmingDepth();
                }
             }
        }
        return maxDepth;
    }

}
