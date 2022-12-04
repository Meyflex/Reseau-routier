package Res.routier;

public class CapteurVitesse extends Capteur {


    public CapteurVitesse(int position, Route route,boolean DirectionDeplacement) {
        super(position, route, DirectionDeplacement);
        route.addCapteur(this);
    }


    public int[] detecteVitesse(){
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for(Voiture c : getRoute().getVoitures()) {
            if (c.getPosition() == this.getPosition()) {
                res[0] = c.getVitesse();
                res[1] = c.getId();
            }
        }
        return res;
    }

    @Override
    public void detecter(Voiture voiture) {

        System.out.println("Capteur de vitesse detecte la voiture "+voiture.getId()+" a la vitesse de "+voiture.getVitesse());



    }
}

