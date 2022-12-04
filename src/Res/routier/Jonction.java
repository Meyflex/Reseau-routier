package Res.routier;

public abstract class  Jonction {
    private Route[] routes;

    public Jonction(Route[] routes) {
        this.routes = routes;

    }

    public Route[] getRoutes() {
        return routes;
    }

    public void setRoutes(Route[] routes) {
        this.routes = routes;
    }

    public abstract void avancer(Voiture voiture) throws SortieDeRoute;
}
