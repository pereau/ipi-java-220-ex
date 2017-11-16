package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {

    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire=Entreprise.SALAIRE_BASE;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche!=null && dateEmbauche.isAfter(LocalDate.now())){

          throw new Exception("La date d'embauche ne peut être postérieure  la date courante") ;
        }
            this.dateEmbauche = dateEmbauche;
        }


    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }


    public Employe(){

    }

    public Employe(String nom,String prenom,String matricule,LocalDate dateEmbauche,Double salaire){

    }



    public abstract Double getPrimeAnnuelle();

    public final Integer getNombreAnneeAnciennete(){
        int annee=LocalDate.now().getYear();
        return dateEmbauche.getYear()-annee;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employe{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", matricule='").append(matricule).append('\'');
        sb.append(", dateEmbauche=").append(dateEmbauche);
        sb.append(", salaire=").append(salaire);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    /*@Override //autre méthode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null) return false;

        return this.hashCode==o.hashCode();//si les attributs de o et de l'instance de Employe sont différents  le hashCode sera différent à fortiori o n'est pas de type Employe.
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public void augmenterSalaire(Double pourcentageAugmentationSalaire){
         this.salaire=this.salaire*(1+pourcentageAugmentationSalaire);

    }
}
