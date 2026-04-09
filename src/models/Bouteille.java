package models;

import java.text.DecimalFormat;

public class Bouteille {
    private final String nom;
    private final double prix;
    private final double contenance;
    private double remplissage;
    private final boolean enVerre;

    public Bouteille(String nom, double prix, double contenance, boolean enVerre) {
        this.nom = nom;
        this.prix = prix;
        this.contenance = contenance;
        this.enVerre = enVerre;
        this.remplissage = 100.0;
    }
    private static String formateur(double valeur) {
            DecimalFormat poison  = new DecimalFormat("##.00");
            return poison.format(valeur);
    }



    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public double getContenance() {
        return contenance;
    }

    public double getRemplissage() {
        return remplissage;
    }

    public boolean isEnVerre() {
        return enVerre;
    }

    public void setRemplissage(double remplissage) {
        this.remplissage = remplissage;
    }



    @Override
    public String toString() {
        return "Bouteille \'" + nom + "\' de " + contenance + "L "+((enVerre) ? "en verre": "pas en verre")+" à "+ formateur(prix) + " Frs - "+((remplissage == 100.0) ? "pleine": (remplissage == 0.0) ? "vide" : "entamée");
    }
    

}
