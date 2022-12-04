package Res.routier;

public class Carrefourd extends Jonction {

    public Carrefourd(Route[] routes) {
        super(routes);
        if (routes.length < 3) {
            throw new IllegalArgumentException("Un carrefour doit avoir 4 routes");
        }else {
            for (int i = 1; i < routes.length; i++) {
                routes[i].setJonction1(this);
            }
            routes[0].setJonction2(this);
        }
    }

    @Override
    public void avancer(Voiture voiture) throws SortieDeRoute {
        for (Semaphores semaphores : voiture.getRoute().getSem()) {
            if (semaphores.isSensdeplacement() == voiture.getSensdeplacement()) {
                semaphores.update(voiture);
            }
        }
    }
}
