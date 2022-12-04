package Res.routier;

import java.util.ArrayList;

public abstract class ElementDeRegulation {
    private ArrayList<Semaphores> semaphores = new ArrayList<>();
    private ArrayList<Capteur> capteurs = new ArrayList<>();


    public ElementDeRegulation() {
    }


    public ArrayList<Semaphores> getSemaphores() {
        return semaphores;
    }

    public void setSemaphores(ArrayList<Semaphores> semaphores) {
        this.semaphores = semaphores;
    }

    public ArrayList<Capteur> getCapteurs() {
        return capteurs;
    }

    public void setCapteurs(ArrayList<Capteur> capteurs) {
        this.capteurs = capteurs;
    }

    public abstract void updateRegulation();
    public abstract void update(Voiture voiture) ;
}
