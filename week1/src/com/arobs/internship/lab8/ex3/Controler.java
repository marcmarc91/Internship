package com.arobs.internship.week1.lab8.ex3;

import java.util.ArrayList;

class Controler {

    String stationName;
    ArrayList<Controler> neighboursController = new ArrayList<>();
    ArrayList<Segment> list = new ArrayList<>();

    public Controler(String gara) {
        stationName = gara;
    }

    void addNeighboursController(Controler v) {
        neighboursController.add(v);
    }

    void addControlledSegment(Segment s) {
        list.add(s);
    }

    int getFreeSegmentId() {
        for (Segment s : list) {
            if (!s.hasTrain())
                return s.id;
        }
        return -1;
    }

    void controlStep() {
        for (Segment segment : list) {
            if (segment.hasTrain()) {
                Train t = segment.getTrain();
                for (Controler c : neighboursController) {
                    if (t.getDestination().equals(c.stationName)) {
                        int id = c.getFreeSegmentId();
                        if (id == -1) {
                            System.out.println("Trenul +" + t.name + "din gara " + stationName + " nu poate fi trimis catre " + c.stationName + ". Nici un segment disponibil!");
                            return;
                        }
                        System.out.println("Trenul " + t.name + " pleaca din gara " + stationName + " spre gara " + c.stationName);
                        segment.departTRain();
                        c.arriveTrain(t, id);
                    }
                }

            }
        }
    }


    public void arriveTrain(Train t, int idSegment) {
        for (Segment segment : list) {
            //search id segment and add train on it
            if (segment.id == idSegment)
                if (segment.hasTrain()) {
                    System.out.println("CRASH! Train " + t.name + " colided with " + segment.getTrain().name + " on segment " + segment.id + " in station " + stationName);
                    return;
                } else {
                    System.out.println("Train " + t.name + " arrived on segment " + segment.id + " in station " + stationName);
                    segment.arriveTrain(t);
                    return;
                }
        }

        //this should not happen
        System.out.println("Train " + t.name + " cannot be received " + stationName + ". Check controller logic algorithm!");

    }


    public void displayStationState() {
        System.out.println("=== STATION " + stationName + " ===");
        for (Segment s : list) {
            if (s.hasTrain())
                System.out.println("|----------ID=" + s.id + "__Train=" + s.getTrain().name + " to " + s.getTrain().destination + "__----------|");
            else
                System.out.println("|----------ID=" + s.id + "__Train=______ catre ________----------|");
        }
    }
}