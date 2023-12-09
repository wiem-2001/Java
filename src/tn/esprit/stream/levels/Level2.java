package tn.esprit.stream.levels;


import tn.esprit.stream.models.Subject;
import tn.esprit.stream.models.Teacher;
import tn.esprit.stream.utils.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(teacher -> {
            return teacher.getName().startsWith("s");
        }).count();
        System.out.println("le nombre des enseignants dont le nom commence avec s : "+nbr);



        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream().filter(teacher -> {
            return teacher.getSubject().equals(Subject.FLUTTER);
        }) .mapToInt(Teacher::getSalary)
                .sum();
        System.out.println("\n la somme des salaires de tous les enseignants Flutter : "+sum);



        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().filter(teacher -> {
            return teacher.getName().startsWith("s");
        }).mapToDouble(Teacher :: getSalary).average() // Calculer la moyenne des salaires
                .orElse(0.0); // Retourner 0.0 si aucun salaire n'est disponible si on le supprime on doit changer le type de resultat
        // en optionalDouble car il existe le cas d'avoir aucun return
        System.out.println("\n la moyenne des salaires des enseignants dont le nom commence avec a : "+average);



        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().filter(teacher -> {
            return teacher.getName().startsWith("f");
        }).collect(Collectors.toList());
        System.out.println("\n la liste des enseignants dont le nom commence par f : ");
        teachers1.stream().forEach(teacher -> System.out.println(teacher.toString()));



        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().filter(teacher -> {
            return teacher.getName().startsWith("s");
        }).collect(Collectors.toList());
        System.out.println("\n la liste des enseignants dont le nom commence par s : ");
        teachers2.stream().forEach(teacher -> System.out.println(teacher.toString()));




        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
        boolean test = teachers.stream().filter(teacher->{
            return teacher.getName().startsWith("n");
        }).anyMatch(teacher -> { return teacher.getSalary()>100000 ;});
        System.out.println("\n l'existence d'au min un enseignants dont le salaire > 100000 : " + test);




        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /*First way*/
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("g") && teacher.getSubject() == Subject.UNITY)
                .findFirst() // Find the first Unity teacher whose name starts with 'g'
                .ifPresentOrElse(
                        System.out::println, // Print the first Unity teacher if present
                        () -> System.out.println("No Unity teacher whose name starts with 'g' found.")
                );

        /*Second way*/
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("g") && teacher.getSubject() == Subject.UNITY)
                .limit(1) // Limit the stream to only one element (if found)
                .forEach(System.out::println); // Print the first Unity teacher whose name starts with 'g'



        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream().filter(teacher -> {
            return teacher.getName().startsWith("s");}).skip(1).findFirst().ifPresentOrElse(
                System.out::println, // Afficher le deuxième enseignant s'il est présent
                () -> System.out.println("Aucun deuxième enseignant dont le nom commence par 's' n'a été trouvé.")
        );
    }
}
