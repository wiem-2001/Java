package tn.esprit.stream.levels;



import tn.esprit.stream.models.Subject;
import tn.esprit.stream.models.Teacher;
import tn.esprit.stream.utils.Data;

import java.util.Comparator;
import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> employees = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        System.out.println("all the employees : \n ");
        employees.stream().forEach(employee -> {
            System.out.println(employee.toString());
        });

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        System.out.println("employees with names starts with n : \n ");
        employees.stream().filter(teacher->{
            return teacher.getName().startsWith("n");
        }).forEach(teacher-> System.out.println(teacher.toString()));

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        System.out.println("employees with names starts with n abd salary > 100000 : \n ");

        employees.stream().filter(teacher->{
            return teacher.getName().startsWith("n");
        }).filter(teacher -> { return teacher.getSalary()>100000 ;}).forEach(teacher-> System.out.println(teacher.toString()));

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        System.out.println("employees with java subject and sorted by salary : \n ");
        employees.stream().filter(teacher -> {
            return teacher.getSubject().equals(Subject.JAVA);
        }).sorted(Comparator.comparingInt(Teacher :: getSalary)).forEach(teacher-> System.out.println(teacher.toString()));

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */
        System.out.println("employees 's names that has salary > 60000 method 1 : \n ");
        /* First Way */
        employees.stream().filter( teacher -> { return teacher.getSalary() >60000 ;}).forEach(teacher-> System.out.println(teacher.getName()));
        /* Second Way */
        System.out.println("employees 's names that has salary > 60000 method 2 : \n ");
        employees.stream().filter(teacher -> { return teacher.getSalary() >60000 ;}).map(Teacher :: getName).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        System.out.println("employees with names starts with m and add 200 tho their salary: \n ");
       employees.stream().filter(teacher -> { return teacher.getName().startsWith("m");}).forEach( teacher -> {
           teacher.setSalary(teacher.getSalary()+200);
           System.out.println(teacher.toString());
       });

    }
}
