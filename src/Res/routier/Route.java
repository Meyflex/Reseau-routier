package Res.routier;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Route {
    private static int idGen = 0;
    private int id;
    private int longueur;
    private Voiture[] voitures=new Voiture[0];
    private Capteur[] capteurs = new Capteur[0];
    private Jonction Jonction1;
    private Jonction Jonction2;
    private Semaphores[] sem = new Semaphores[0];

    public Route(int i,Voiture[] voitures) {
        this.longueur = i;
        this.id=idGen++;
        this.idGen++;
        this.voitures = voitures;
    }
    public Route(int i) {
        this.id=idGen++;
        this.idGen++;
        this.longueur = i;
    }
    public Route(int i, Voiture[] voitures ,Jonction Jonction1,Jonction Jonction2) {
        this.longueur = i;
        this.voitures = voitures;
        this.Jonction1 = Jonction1;
        this.Jonction2 = Jonction2;
        this.id=idGen++;
        this.idGen++;


    }


    public void setSem(Semaphores [] sema ){
        this.sem=sema;
    }
    public void setCapteurs(Capteur [] capt ){
        this.capteurs=capt;
    }
    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getId() {
        return id;
    }

    public Voiture[] getVoitures() {
        return voitures;
    }

    public Capteur[] getCapteurs() {
        return capteurs;
    }

    public Jonction getJonction1() {
        return Jonction1;
    }

    public Jonction getJonction2() {
        return Jonction2;
    }

    public void setJonction2(Jonction jonction2) {
        Jonction2 = jonction2;
    }

    public void setJonction1(Jonction jonction1) {
        Jonction1 = jonction1;
    }

    public Semaphores[] getSem() {
        return sem;
    }

    public void avancer(Voiture voiture) throws SortieDeRoute {
        int vitesse = voiture.getVitesse();

        if (voiture.getSensdeplacement()) {;

            if (voiture.getPosition() + voiture.getVitesse() >= longueur) {
                voiture.setVitesse(longueur - voiture.getPosition());
                voiture.setPosition(voiture.getPosition() + voiture.getVitesse());
                if(voiture.getPosition()-longueur==0){
                    Jonction1.avancer(voiture);
                }
            } else {
                voiture.setPosition(voiture.getPosition() + voiture.getVitesse());

            }
            for (Capteur capteur : capteurs) {
                if ((capteur.getPosition() >= voiture.getPosition()
                        && capteur.getPosition() <= voiture.getPosition() + voiture.getVitesse())
                        && capteur.getDirectionDeplacement() == voiture.getSensdeplacement()) {
                    capteur.detecter(voiture);
                }
            }
        }else {

            if (voiture.getPosition() - voiture.getVitesse() < 0) {
                voiture.setVitesse(voiture.getPosition());
                voiture.setPosition(voiture.getPosition() - voiture.getVitesse());
                if(voiture.getPosition()==0){
                    Jonction2.avancer(voiture);
                }
            } else {
                voiture.setPosition(voiture.getPosition() - voiture.getVitesse());
            }
            for (Capteur capteur : capteurs) {
                if ((capteur.getPosition() <= voiture.getPosition()
                        && capteur.getPosition() >= voiture.getPosition() - voiture.getVitesse())
                        && capteur.getDirectionDeplacement() == voiture.getSensdeplacement()) {
                    capteur.detecter(voiture);
                }
            }
        }
        System.out.println( " la voiture n'" + voiture.getId()+ " est sur la route numero : " +this.id+ " a la position " + voiture.getPosition());

}
        public void addCapteur(Capteur c){
                this.capteurs=Arrays.copyOf(this.capteurs,this.capteurs.length+1);
                this.capteurs[this.capteurs.length-1]=c;
        }


    public void addVoiture(Voiture voiture) {
        this.voitures = Arrays.copyOf(this.voitures, this.voitures.length + 1);
        this.voitures[this.voitures.length - 1] = voiture;
    }
}