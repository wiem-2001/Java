package tn.esprit.gestionEmploye;

import java.util.*;

public class AffectationHashMap {
    private Map<Employe, Departement> affectations;
    public AffectationHashMap() {
        affectations = new HashMap<>();
    }

    public Map<Employe, Departement> getAffectations() {
        return affectations;
    }

    public void setAffectations(Map<Employe, Departement> affectations) {
        this.affectations = affectations;
    }

    public void ajouterEmployeDepartement(Employe e, Departement d){
            affectations.put(e,d);
    }
    public void afficherEmployesEtDepartements (){
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            Employe employe = entry.getKey();
            Departement departement = entry.getValue();
            System.out.println("Employé : " + employe + " - Département : " + departement.getNom());
        }
    }
    public void supprimerEmploye(Employe employe) {
        Iterator<Map.Entry<Employe, Departement>> iterator = affectations.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Employe, Departement> entry = iterator.next();
            Employe e = entry.getKey();
            if (e.equals(employe)) {
                iterator.remove();
                System.out.println("L'employé " + employe.getNom() + " a été supprimé de la collection.");
                return;
            }
        }
        System.out.println("L'employé " + employe.getNom() + " n'est pas présent dans la collection.");
    }
    public void supprimerEmployeEtDepartement (Employe e,Departement d){
        Iterator<Map.Entry<Employe, Departement>> iterator = affectations.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Employe, Departement> entry = iterator.next();
            Employe employe = entry.getKey();
            Departement departement = entry.getValue();
            if (employe.equals(e) && departement.equals(d)) {
                iterator.remove();
                System.out.println("L'employé " + employe + " a été supprimé du département " + departement.getNom());
                return;
            }
        }

        System.out.println("L'employé " + e + " n'est pas affecté au département " + d.getNom());
    }
    public void afficherEmployes() {
        for (Employe employe : affectations.keySet()) {
            System.out.println(employe);
        }
    }
    public boolean rechercherEmploye(Employe e){
        return affectations.containsKey(e);
    }
    public boolean rechercherDepartement (Departement d){
        return affectations.containsValue(d);
    }
    public void afficherDepartments(){
        Collection<Departement> departments = affectations.values();
        System.out.println("Departments: ");
        for(Departement d : departments){
            System.out.println(d.getId() + ", " + d.getNom());
        }
    }
    TreeMap<Employe, Departement> trierMap(){
        Comparator<Employe> Compartor = new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return o1.getId() - o2.getId();
            }
        };
        TreeMap<Employe, Departement> newDetails = new TreeMap<>(Compartor);
        newDetails.putAll(affectations);
        return newDetails;
    }
}
