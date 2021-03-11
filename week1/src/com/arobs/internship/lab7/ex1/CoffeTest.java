package com.arobs.internship.week1.lab7.ex1;

public class CoffeTest {
    public static void main(String[] args) {
        CofeeMaker mk = new CofeeMaker();
        CofeeDrinker d = new CofeeDrinker();

        for (int i = 0; i < 15; i++) {
            Cofee c = null;
            try {
                c = mk.makeCofee(i);
                d.drinkCofee(c);
            } catch (TemperatureException e) {
                System.out.println("Exception:" + e.getMessage() + " temp=" + e.getTemp());
            } catch (ConcentrationException e) {
                System.out.println("Exception:" + e.getMessage() + " conc=" + e.getConc());
            } catch (CountCoffeeException e) {
                System.out.println("Exception:" + e.getMessage() + e.getLimit());
            } finally {
                System.out.println("Throw the cofee cup.\n");
            }
        }
    }
}