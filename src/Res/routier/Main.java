package Res.routier;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SortieDeRoute {


        Route routesimple = new Route(100);


        Route routesimple1 = new Route(100);

        Route routecarrefourd = new Route(100);
        Route routecarrefourd1 = new Route(100);
        Route routecarrefourd2 = new Route(100);
        Route routecarrefourd3 = new Route(100);



        Voiture voiture1 = new Voiture(5, 0, true);
        Voiture voiture2 = new Voiture(10, 0, true);
        Voiture voiture3 = new Voiture(10, 0, true);

        Route[] routepietons = new Route[2];
        routepietons[0] = routesimple;
        routepietons[1] = routesimple1;
        Jonction jonctionPietons = new PassagePieton(routepietons);

        Route[] routepietons1 = new Route[2];
        routepietons1[0] = routesimple1;
        routepietons1[1] = routecarrefourd;
        Jonction jonctionPietons1 = new PassagePieton(routepietons1);


        Route[] mur = new Route[1];
        mur[0] = routesimple;
        Jonction jonctionMur = new Barriere(mur, true);

        Route[] mur2 = new Route[1];
        mur2[0] = routesimple1;
        Jonction jonctionMur2 = new Barriere(mur, true);

        Route[] routecarrefours = new Route[4];
        routecarrefours[0] = routecarrefourd;
        routecarrefours[1] = routecarrefourd1;
        routecarrefours[2] = routecarrefourd2;
        routecarrefours[3] = routecarrefourd3;
        Jonction jonctionCarrefour = new Carrefourd(routecarrefours);

        Route[] mur3 = new Route[1];
        mur[0] = routecarrefourd;
        Jonction jonctionMur3 = new Barriere(mur, true);

        Route[] mur4 = new Route[1];
        mur2[0] = routecarrefourd1;
        Jonction jonctionMur4 = new Barriere(mur2, true);

        Route[] mur5 = new Route[1];
        mur3[0] = routecarrefourd2;
        Jonction jonctionMur5 = new Barriere(mur3, true);

        Route[] mur6 = new Route[1];
        mur4[0] = routecarrefourd3;
        Jonction jonctionMur6 = new Barriere(mur4, true);

        ElementDeRegulation elemReg1 = new RegulationCarrefourdFeuOrder();
        FeuTricolore feuTri1 = new FeuTricolore(true, routecarrefourd, "vert", elemReg1);
        elemReg1.getSemaphores().add(feuTri1);
        FeuTricolore feuTri2 = new FeuTricolore(true, routecarrefourd1, "rouge", elemReg1);
        elemReg1.getSemaphores().add(feuTri2);
        FeuTricolore feuTri3 = new FeuTricolore(true, routecarrefourd2, "rouge", elemReg1);
        elemReg1.getSemaphores().add(feuTri3);
        FeuTricolore feuTri4 = new FeuTricolore(true, routecarrefourd3, "rouge", elemReg1);
        elemReg1.getSemaphores().add(feuTri4);

        Semaphores[] semaphores = new Semaphores[1];
        semaphores[0] = feuTri1;
        routecarrefourd.setSem(semaphores);
        Semaphores[] semaphores1 = new Semaphores[1];
        semaphores1[0] = feuTri2;
        routecarrefourd1.setSem(semaphores1);
        Semaphores[] semaphores2 = new Semaphores[1];
        semaphores2[0] = feuTri3;
        routecarrefourd2.setSem(semaphores2);
        Semaphores[] semaphores3 = new Semaphores[1];
        semaphores3[0] = feuTri4;
        routecarrefourd3.setSem(semaphores3);




        routesimple.setJonction1(jonctionPietons);
        routesimple.setJonction2(jonctionMur);
        routesimple1.setJonction1(jonctionPietons);
        routesimple1.setJonction2(jonctionPietons1);



        routecarrefourd.setJonction1(jonctionCarrefour);
        routecarrefourd1.setJonction1(jonctionCarrefour);
        routecarrefourd2.setJonction1(jonctionCarrefour);
        routecarrefourd3.setJonction1(jonctionCarrefour);
        routecarrefourd.setJonction2(jonctionPietons1);
        routecarrefourd1.setJonction2(jonctionMur4);
        routecarrefourd2.setJonction2(jonctionMur5);
        routecarrefourd3.setJonction2(jonctionMur6);


        Capteur capteur = new CapteurPresence(10,routesimple, true);
        Capteur capteurVitesse = new CapteurVitesse(10,routesimple, true);
        Capteur capteur2 = new CapteurPresence(10,routesimple1, true);
        Capteur capteurVitesse2 = new CapteurVitesse(10,routesimple1, true);





        System.out.println(" le id de routecarrefourd est : " + routecarrefourd.getId());
        System.out.println(" le id de routecarrefourd1 est : " + routecarrefourd1.getId());
        System.out.println(" le id de routecarrefourd2 est : " + routecarrefourd2.getId());
        System.out.println(" le id de routecarrefourd3 est : " + routecarrefourd3.getId());
        System.out.println(" le id de routesimple est : " + routesimple.getId());
        System.out.println(" le id de routesimple1 est : " + routesimple1.getId());

        voiture2.setRoute(routecarrefourd3);
        voiture3.setRoute(routesimple);

        for (int i = 0; i < 100; i++) {
            System.out.println("Temps " + i + " : ");

            voiture3.avancer();
            voiture2.avancer();
            elemReg1.updateRegulation();
        }
    }
}