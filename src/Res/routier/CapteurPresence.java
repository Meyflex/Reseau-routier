package Res.routier;

public class CapteurPresence extends Capteur {
    static int NbrAccident = 0;
    private boolean presence;

    public CapteurPresence(int position, Route route,boolean DirectionDeplacement,ElementDeRegulation [] elementDeRegulations) {
        super(position, route, DirectionDeplacement, elementDeRegulations);
        this.presence = false;
        route.addCapteur(this);
    }
    public CapteurPresence(int position, Route route,boolean DirectionDeplacement) {
        super(position, route, DirectionDeplacement,new ElementDeRegulation[0]);
        this.presence = false;
        route.addCapteur(this);
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public int presence(){
        for(Voiture c : getRoute().getVoitures()){
            if (c.getPosition()==this.getPosition()){
                return c.getId();
            }
        }
        return -1;
    }

    @Override
    public void detecter(Voiture voiture) {
        System.out.println("Capteur de presence detecte la voiture "+voiture.getId());
        presence = true;
        for (Voiture v : getRoute().getVoitures()){
            if (v.getPosition() == voiture.getPosition() && v.getId() != voiture.getId()){
                System.out.println("La voiture "+voiture.getId()+" est en collision avec la voiture "+v.getId());
                NbrAccident++;
                System.out.println("Nombre d'accidents enregistre par le capteur : "+NbrAccident);
            }
    }

    }


}

