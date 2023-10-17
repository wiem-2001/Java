public class Animal {

    String family, name;
    int age;
    boolean isMammal;

    public Animal() {

    }

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }
public int getAge()
{
    return this.age;
}
public void setAge(int age)
{
    if(age!=0)
    {
        this.age=age;
    }
    else{
        system.out.println("Un animal ne peut pas avoir un âge négatif");
    }
}
    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMammal=" + isMammal +
                '}' ; 
    }
}
