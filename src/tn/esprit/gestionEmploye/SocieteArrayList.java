package tn.esprit.gestionEmploye;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe>{
    List<Employe> Employees = new ArrayList<Employe>();
    @Override
    public void ajouterEmploye(Employe employe) {
        Employees.add(employe);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
     boolean r=false;
        for(Employe e : Employees){
            if(e.getNom().equals(nom)){
                r=true;
            }
        }
        return r;
    }

    @Override
    public boolean rechercherEmploye(Employe employee) {
        for(Employe e : Employees){
            if(e == employee)
                return true;
        }
        return false;
    }


    @Override
    public void supprimerEmploye(Employe employe) {
        Employees.remove(employe);
    }

    @Override
    public void displayEmploye() {
        System.out.println(Employees);
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(Employees);
    }
    Comparator<Employe> GradeCompartor = new Comparator<Employe>() {
        @Override
        public int compare(Employe o1, Employe o2) {
            return o1.getGrade() - o2.getGrade();
        }
    };


    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Comparator<Employe> NomDepartementCompartor = new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getNomDep().compareTo(o2.getNomDep());
            }
        };

        Comparator<Employe> GradeCompartor = new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getGrade() - o2.getGrade();
            }
        };

        Collections.sort(Employees, NomDepartementCompartor.thenComparing(GradeCompartor));
    }
}
