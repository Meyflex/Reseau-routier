package Res.routier;

public abstract  class  Semaphores {
    private boolean Sensdeplacement;
    private static int idGen = 0;
    private int id;
    private ElementDeRegulation elementDeRegulations;

    private Route route;


    public Semaphores(boolean Sensdeplacement, Route route,ElementDeRegulation elementDeRegulations) {
        this.Sensdeplacement = Sensdeplacement;
        this.elementDeRegulations = elementDeRegulations;
        this.id = idGen++;
        this.route = route;
    }

    public boolean isSensdeplacement() {
        return Sensdeplacement;
    }

    public void setSensdeplacement(boolean sensdeplacement) {
        Sensdeplacement = sensdeplacement;
    }


    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public abstract void update(Voiture voiture) ;

    public ElementDeRegulation getElementDeRegulations() {
        return elementDeRegulations;
    }

    public void setElementDeRegulations(ElementDeRegulation elementDeRegulations) {
        this.elementDeRegulations = elementDeRegulations;
    }
}
