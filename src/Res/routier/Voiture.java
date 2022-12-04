package Res.routier;

public class Voiture {
    private static int idGen = 0;
    private final int  longueur = 1;
    private int id;
    private int vitesse;
    private Route route;
    private int position;
    private final int  vitesseMax;
    private boolean Sensdeplacement;


    public Voiture(int vitesse, int position, boolean Sensdeplacement) {
        this.id = idGen++;
        idGen++;
        this.vitesse = vitesse;
        this.vitesseMax=vitesse;
        this.position = position;
        this.Sensdeplacement = Sensdeplacement;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getSensdeplacement() {
        return Sensdeplacement;
    }

    public void setSensdeplacement(boolean sensdeplacement) {
        Sensdeplacement = sensdeplacement;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
        this.route.addVoiture(this);
    }

    public int getLongueur() {
        return longueur;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    /**
     * methode qui permet de deplacer la voiture vers l'avant
     */
    public void avancer() throws SortieDeRoute {
        this.route.avancer(this);
    }
}
