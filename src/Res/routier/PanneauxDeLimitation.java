package Res.routier;

public class PanneauxDeLimitation extends  Semaphores{
    private int vitesseMax;

    public PanneauxDeLimitation(boolean Sensdeplacement, Route route, int vitesseMax,ElementDeRegulation elementDeRegulations) {
        super(Sensdeplacement,route,elementDeRegulations);
        this.vitesseMax = vitesseMax;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    @Override
    public void update(Voiture voiture) {
        if (voiture.getVitesse() > this.vitesseMax){
            voiture.setVitesse(this.vitesseMax);
        }

    }
}
