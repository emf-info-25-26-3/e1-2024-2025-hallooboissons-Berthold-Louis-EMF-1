package app;

import models.Bouteille;
import models.Cageot;
import models.Client;
import models.Commande;

public class Application {

    public static void main(String[] args) {
        Client Jean = new Client("DUCOBU", "Jean", "Bulle");
        Client Marc = new Client("HARONI", "Marc", "Fribourg");
        Bouteille HR = new Bouteille("Henniez rouge", 2.60, 1, true);
        Bouteille HV = new Bouteille("Henniez verte", 2.60, 1, true);
        Bouteille CC = new Bouteille("Coca-Cola", 3.85, 1.5, false);
        Bouteille P = new Bouteille("Pepsi", 3.55, 1.5, false);
        Bouteille S = new Bouteille("Sinalco", 4.25, 1.5, false);
        Cageot X83H4 = new Cageot("X83H4");
        for(int i = 0; i<6;i++){
            X83H4.ajoutBouteille(HR);
            X83H4.ajoutBouteille(HV);
        }

        Cageot X83H5 = new Cageot("X83H5");
        for(int i = 0; i<2;i++){
            X83H5.ajoutBouteille(CC);
        }

        Cageot X83H6 = new Cageot("X83H6");
            X83H6.ajoutBouteille(P);
            X83H6.ajoutBouteille(S);

        Cageot X83H7 = new Cageot("X83H7");
            X83H7.ajoutBouteille(HR);
            X83H7.ajoutBouteille(CC);
            X83H7.ajoutBouteille(CC);

        Commande[] commandes = new Commande[10];
        commandes[1] = new Commande(Jean);
        commandes[1].ajoutCageot(X83H4);
        commandes[1].ajoutCageot(X83H5);
        commandes[1].ajoutCageot(X83H6);
        commandes[2] = new Commande(Marc);
        commandes[2].ajoutCageot(X83H7);

        afficherCommande(commandes[1]);
        afficherCommande(commandes[2]);

    }

    public static void afficherCommande(Commande commande) {
    
        if (commande != null) {
            System.out.println("-----------------------------");
            System.out.println("Commande pour le client : " + commande.getClient());
            Cageot[] CageotALivrer = commande.getListeCageot();
            System.out.println("la commande contient "+CageotALivrer.length+" cageots");
            System.out.println("Le prix total de la commande est de " + commande.prixTotal() + " Frs");
        }
    }
}
