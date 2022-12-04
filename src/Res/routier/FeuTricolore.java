package Res.routier;

public class FeuTricolore extends Semaphores {
    private String couleur;

    public FeuTricolore(boolean Sensdeplacement, Route route, String couleur, ElementDeRegulation elementDeRegulations) {
        super(Sensdeplacement, route, elementDeRegulations);
        if (couleur.equals("rouge") || couleur.equals("vert") || couleur.equals("orange")) {
            this.couleur = couleur;
        } else {
            throw new IllegalArgumentException("La couleur doit être rouge, vert ou orange");
        }
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }


    @Override
    public void update(Voiture voiture) {
            getElementDeRegulations().update(voiture);

    }


}

