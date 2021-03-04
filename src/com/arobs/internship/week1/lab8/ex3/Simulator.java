package com.arobs.internship.week1.lab8.ex3;

public class Simulator {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //build station Cluj-Napoca
        Controler c1 = new Controler("Cluj-Napoca");

        Segment s1 = new Segment(1);
        Segment s2 = new Segment(2);
        Segment s3 = new Segment(3);

        c1.addControlledSegment(s1);
        c1.addControlledSegment(s2);
        c1.addControlledSegment(s3);

        //build station Baia-Mare
        Controler c3 = new Controler("Baia-Mare");

        Segment s7 = new Segment(7);
        Segment s8 = new Segment(8);
        Segment s9 = new Segment(9);

        c3.addControlledSegment(s7);
        c3.addControlledSegment(s8);
        c3.addControlledSegment(s9);

        //build station Bucuresti
        Controler c2 = new Controler("Bucuresti");

        Segment s4 = new Segment(4);
        Segment s5 = new Segment(5);
        Segment s6 = new Segment(6);

        c2.addControlledSegment(s4);
        c2.addControlledSegment(s5);
        c2.addControlledSegment(s6);

        //build station Brasov
        Controler c4 = new Controler("Brasov");

        Segment s10 = new Segment(10);
        Segment s11 = new Segment(11);
        Segment s12 = new Segment(12);

        c4.addControlledSegment(s10);
        c4.addControlledSegment(s11);
        c4.addControlledSegment(s12);


        c1.addNeighboursController(c2);
        c1.addNeighboursController(c4);
        c2.addNeighboursController(c1);
        c2.addNeighboursController(c3);
        c2.addNeighboursController(c4);
        c4.addNeighboursController(c2);
        c4.addNeighboursController(c3);
        c3.addNeighboursController(c1);

        //testing

        Train t1 = new Train("Bucuresti", "IC-001");
        s1.arriveTrain(t1);

        Train t2 = new Train("Cluj-Napoca", "R-002");
        s5.arriveTrain(t2);

        Train t3 = new Train("Baia-Mare", "R-032");
        s11.arriveTrain(t3);

        Train t4 = new Train("Brasov", "R-041");
        s6.arriveTrain(t4);


        c1.displayStationState();
        c2.displayStationState();
        c3.displayStationState();
        c4.displayStationState();

        System.out.println("\nStart train control\n");

        //execute 3 times controller steps
        for (int i = 0; i < 3; i++) {
            System.out.println("### Step " + i + " ###");
            c1.controlStep();
            c2.controlStep();
            c3.controlStep();
            c4.controlStep();

            System.out.println();

            c1.displayStationState();
            c2.displayStationState();
            c3.displayStationState();
            c4.displayStationState();
        }
    }

}