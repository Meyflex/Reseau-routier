package Res.routier;

public class Barriere extends Jonction {
        boolean sens;
        public Barriere(Route[] routes,boolean sens) {
            super(routes);
            if (routes.length != 1) {
                throw new IllegalArgumentException("Une barrière doit avoir 1 route");
            }else if (sens == true){
                routes[0].setJonction2(this);
            }else {
                routes[0].setJonction1(this);
            }

        }


    @Override
    public void avancer(Voiture voiture) throws SortieDeRoute {
        System.out.println("La voiture " + voiture.getId() + " est arrivee a une barriere ! ");
        voiture.setVitesse(0);
    }
}

