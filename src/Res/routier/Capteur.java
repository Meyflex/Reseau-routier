package Res.routier;

public abstract class Capteur {
    private int position;
    private Route route;

    private ElementDeRegulation [] elementDeRegulations ;

    private boolean DirectionDeplacement;

    public Capteur(int position, Route route,boolean DirectionDeplacement, ElementDeRegulation[] elementDeRegulations) {
        this.position = position;
        this.route = route;
        this.DirectionDeplacement = DirectionDeplacement;
        this.elementDeRegulations = elementDeRegulations;
    }
    public Capteur(int position,boolean DirectionDeplacement, ElementDeRegulation[] elementDeRegulations) {
        this.position = position;
        this.DirectionDeplacement = DirectionDeplacement;
        this.elementDeRegulations = elementDeRegulations;
    }
    public Capteur(int position, Route route,boolean DirectionDeplacement) {
        this.position = position;
        this.DirectionDeplacement = DirectionDeplacement;
        this.elementDeRegulations = new ElementDeRegulation[0];
        this.route = route;
    }



    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public abstract void  detecter(Voiture voiture) ;

    public boolean getDirectionDeplacement() {
        return DirectionDeplacement;
    }

    public void setDirectionDeplacement(boolean directionDeplacement) {
        DirectionDeplacement = directionDeplacement;
    }

    public ElementDeRegulation[] getElementDeRegulations() {
        return elementDeRegulations;
    }

    public void setElementDeRegulations(ElementDeRegulation[] elementDeRegulations) {
        this.elementDeRegulations = elementDeRegulations;
    }


    public boolean isPresence() {
        return false;
    }
}
