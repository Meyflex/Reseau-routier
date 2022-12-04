package Res.routier;

public class PassagePieton extends Jonction {
    private boolean sens;

    public PassagePieton(Route[] routes) {
        super(routes);

        if (routes.length != 2) {
            throw new IllegalArgumentException("Un passage piéton doit avoir 2 routes");
        }
    }

    @Override
    public void avancer(Voiture voiture) throws SortieDeRoute {

        if(getRoutes()[0].getId() == (voiture.getRoute().getId())){
            if(voiture.getPosition()==0 && !voiture.getSensdeplacement()){
                voiture.setSensdeplacement(!voiture.getSensdeplacement());
                voiture.setRoute(getRoutes()[1]);
                voiture.setPosition(0);
                voiture.setVitesse(getRoutes()[0].getLongueur()/10);

                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }else if (voiture.getPosition()==0 && voiture.getSensdeplacement()){
                voiture.setSensdeplacement(!voiture.getSensdeplacement());
                voiture.setRoute(getRoutes()[1]);
                voiture.setPosition(0);
                voiture.setVitesse(getRoutes()[0].getLongueur()/10);

                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }
            if(voiture.getPosition()==getRoutes()[0].getLongueur() && voiture.getSensdeplacement()){
                voiture.setSensdeplacement(!voiture.getSensdeplacement());
                voiture.setRoute(getRoutes()[1]);
                voiture.setPosition(getRoutes()[1].getLongueur());
                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }else if (voiture.getPosition()==getRoutes()[0].getLongueur() && !voiture.getSensdeplacement()){
                voiture.setSensdeplacement(!voiture.getSensdeplacement());
                voiture.setRoute(getRoutes()[1]);
                voiture.setPosition(getRoutes()[1].getLongueur());
                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }
        }else{
            if(voiture.getPosition()==0 && voiture.getSensdeplacement()){
                voiture.setSensdeplacement(!voiture.getSensdeplacement());
                voiture.setRoute(getRoutes()[0]);
                voiture.setPosition(0);
                voiture.setVitesse(getRoutes()[0].getLongueur()/10);
                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }else if (voiture.getPosition() == 0 && !voiture.getSensdeplacement()) {
                voiture.setSensdeplacement(!voiture.getSensdeplacement());

                voiture.setRoute(getRoutes()[0]);
                voiture.setPosition(0);
                voiture.setVitesse(getRoutes()[0].getLongueur() / 10);

                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }
            if(voiture.getPosition()==getRoutes()[1].getLongueur() && !voiture.getSensdeplacement()){
                voiture.setSensdeplacement(!voiture.getSensdeplacement());
                voiture.setRoute(getRoutes()[0]);

                voiture.setPosition(getRoutes()[0].getLongueur());
                System.out.println(getRoutes()[0].getLongueur());
                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");

            }else if (voiture.getPosition() == getRoutes()[1].getLongueur() && voiture.getSensdeplacement()) {
                voiture.setSensdeplacement(!voiture.getSensdeplacement());

                voiture.setRoute(getRoutes()[0]);
                voiture.setPosition(getRoutes()[0].getLongueur());

                System.out.println("La voiture " + voiture.getId() + " passe par un passage pièton ! ");
            }

        }
    }

    public boolean isSens() {
        return sens;
    }

    public void setSens(boolean sens) {
        this.sens = sens;
    }
}

