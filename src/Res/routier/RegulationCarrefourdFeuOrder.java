package Res.routier;

import java.util.ArrayList;

public class RegulationCarrefourdFeuOrder extends  ElementDeRegulation{
    private int tempsVert;
    public RegulationCarrefourdFeuOrder() {

    }

    @Override
    public void update(Voiture voiture) {

        for (Semaphores semaphores : this.getSemaphores()) {
            if (semaphores instanceof FeuTricolore) {
                if(semaphores.getRoute().getId()==voiture.getRoute().getId()){
                    if (((FeuTricolore) semaphores).getCouleur().equals("vert")) {
                        int routeAleatoire = (int) Math.random()*(getSemaphores().size());
                        if(routeAleatoire>=getSemaphores().size() ||
                                routeAleatoire==getSemaphores().indexOf(semaphores)){
                            routeAleatoire=getSemaphores().size()-1;
                        }
                        if(voiture.getPosition()==voiture.getRoute().getLongueur()){
                            voiture.setRoute(getSemaphores().get(routeAleatoire).getRoute());
                            voiture.setPosition(voiture.getRoute().getLongueur());
                        }else{
                            voiture.setRoute(getSemaphores().get(routeAleatoire).getRoute());
                            voiture.setPosition(0);
                        }

                        voiture.setSensdeplacement(!voiture.getSensdeplacement());
                        voiture.setVitesse(voiture.getVitesseMax());
                        System.out.println("La voiture " + voiture.getId() +
                                " passe par un feu vert d'un carrefour.");

                        return;
                    }
                    else if (((FeuTricolore) semaphores).getCouleur().equals("rouge")) {
                        voiture.setVitesse(0);
                        System.out.println("La voiture " + voiture.getId() +
                                " est arrete a un feu rouge d'un carrefour.");
                        return;
                    }
                }
            }
        }
    }
    @Override
    public void updateRegulation() {
        for (Semaphores semaphores : this.getSemaphores()) {
            if (semaphores instanceof FeuTricolore) {

                if(((FeuTricolore) semaphores).getCouleur().equals("vert")) {
                    ((FeuTricolore) getSemaphores().get(getSemaphores().
                            indexOf(semaphores))).setCouleur("rouge");
                    if(getSemaphores().indexOf(semaphores)< getSemaphores().size()-1) {
                        ((FeuTricolore) getSemaphores().get(getSemaphores().
                                indexOf(semaphores) + 1)).setCouleur("vert");
                    }else{
                        ((FeuTricolore) getSemaphores().get(0)).setCouleur("vert");
                    }
                    return;
                }
            }
        }
    }

}
