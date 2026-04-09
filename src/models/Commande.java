package models;

public class Commande {
    public static final int CAGEOT_MAX = 8;
    private final Client client;
    private Cageot[] listeCageot;
    
    public Commande(Client client) {
        this.client = client;
        this.listeCageot = new Cageot[CAGEOT_MAX];
    }

    public boolean ajoutCageot(Cageot nouvCageot){
        boolean reussite = false;
        for(int i = 0; i<listeCageot.length; i++){
            if (listeCageot[i] == null) {
                listeCageot[i] = nouvCageot;
                reussite = true;
                break;
            }
        }
        return reussite;
    }
    public boolean suppressionCageot(Cageot nouvCageot){
        boolean reussite = false;
        for(int i = 0; i<listeCageot.length; i++){
            if (listeCageot[i] == nouvCageot) {
                listeCageot[i] = null;
                reussite = true;
                break;
            }
        }
        return reussite;
    }

    public double prixTotal(){
        double prixRetour = 0;
        for(int i = 0; i < listeCageot.length; i++){
            if (listeCageot[i] != null) {
                prixRetour = prixRetour + listeCageot[i].prixTotal();
            }
        }
        return prixRetour;
    }

    public void annulation(){
        for(int i = 0; i<listeCageot.length; i++){
            listeCageot[i] = null;
        }
    }

    public Client getClient() {
        return client;
    }

    public Cageot[] getListeCageot() {
        int nbrPlace = 0;
        for(int i = 0; i<listeCageot.length; i++){
            if (listeCageot[i] == null) {
                nbrPlace ++;
            }
        }
        Cageot[] listeCageotRetour = new Cageot[(listeCageot.length - nbrPlace)];
        int increment= 0;
        for(int i = 0; i<listeCageot.length; i++){
            if (listeCageot[i] != null) {
                listeCageotRetour[increment] = listeCageot[i];
                increment ++;
            }
        }
        return listeCageotRetour;
    }
    
}
