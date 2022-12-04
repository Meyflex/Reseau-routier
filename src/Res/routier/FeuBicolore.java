package Res.routier;

public class FeuBicolore extends Semaphores{
    private String couleur;

    public FeuBicolore(boolean Sensdeplacement,int position, Route route, String couleur,ElementDeRegulation elementDeRegulations) {
        super(Sensdeplacement, route,elementDeRegulations);
        if(couleur.equals("rouge") || couleur.equals("vert") ){
            this.couleur = couleur;
        }
        else{
            throw new IllegalArgumentException("La couleur doit être rouge ou vert");
        }
    }


    @Override
    public void update(Voiture voiture) {
        if (this.couleur.equals("rouge")){
            voiture.setVitesse(0);
        }
    }
}
