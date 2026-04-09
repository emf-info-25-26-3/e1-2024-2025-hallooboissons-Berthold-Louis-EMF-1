package models;

import java.text.DecimalFormat;

public class Cageot {
    public static final int BOUTEILLES_MAX = 12;
    private final String ID;
    Bouteille[] bouteilles;
    
    public Cageot( String iD) {
        ID = iD;
        this.bouteilles = new Bouteille[BOUTEILLES_MAX];
    }

    public boolean ajoutBouteille(Bouteille nouvBouteille){
        boolean reussite = false;
        for(int i = 0; i<bouteilles.length; i++){
            if (bouteilles[i] == null) {
                bouteilles[i] = nouvBouteille;
                reussite = true;
                break;
            }
        }
        return reussite;
    }

    public boolean enleverBouteille(Bouteille bouteilleAEnlever){
        boolean reussite = false;
        for(int i = 0; i<bouteilles.length; i++){
            if (bouteilles[i] == bouteilleAEnlever) {
                bouteilles[i] = null;
                reussite = true;
                break;
            }
        }
        return reussite;
    }
    public int nbrBouteille(){
        int nbrBouteille = 0;
        for(int i = 0; i<bouteilles.length; i++){
            if (bouteilles[i] != null) {
                nbrBouteille ++;
            }
        }
        return nbrBouteille;
    }
    public int nbrPlace(){
        int nbrPlace = 0;
        for(int i = 0; i<bouteilles.length; i++){
            if (bouteilles[i] == null) {
                nbrPlace ++;
            }
        }
        return nbrPlace;
    }

    public Bouteille[] getListBouteilles(){
        Bouteille[] retour = new Bouteille[(bouteilles.length-nbrPlace())];
        int increment = 0;
        for(int i = 0; i<bouteilles.length; i++){
            if (bouteilles[i] != null) {
                retour[increment] = bouteilles[i];
            }
        }
        return retour;
    }
    public double prixTotal(){
        double prixRetour = 0.0;
        for(int i = 0; i<bouteilles.length; i++){
            if (bouteilles[i] != null) {
                prixRetour =+ bouteilles[i].getPrix();
            }
        }
        return prixRetour;
    }
    private static String formateur(int valeur) {
            DecimalFormat poison  = new DecimalFormat("00");
            return poison.format(valeur);
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Cageot \'" + ID + "\' avec " + formateur(nbrBouteille()) + "/" + formateur(nbrPlace()) + " bouteilles";
    }

        

}
/*38 min à 14:39 recommençé à 15:49*/