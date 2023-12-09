package tn.esprit.stream.levels;

import tn.esprit.stream.models.Subject;
import tn.esprit.stream.models.Teacher;
import tn.esprit.stream.utils.Data;

import java.util.*;
import java.util.stream.Collectors;


public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
      String names = teachers.stream().map(Teacher::getName).map(String::toUpperCase).reduce((name1, name2) -> name1 + "#" + name2)
              .orElse("");
        System.out.println("la liste de tous les noms des enseignants en majuscule separés par # : "+names);



        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
       Set<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.JAVA && teacher.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("\n set d'enseignants Java dont le salaire > 80000 : " );
        teachers1.forEach(teacher -> System.out.println(teacher.toString()));


        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
       TreeSet<Teacher> teachers2 = teachers.stream().collect(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(Teacher::getName).thenComparing(Teacher::getSalary))));
        System.out.println("\n TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) : " );
        teachers2.forEach(teacher -> System.out.println(teacher.toString()));


        /* TO DO 4: Retourner une Map qui regroupe les nom des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream()
                .collect(Collectors.groupingBy(
                        Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))
                ));
        System.out.println("\n Map qui regroupe les noms des enseignants par salaire : " + map1);
    }
}
