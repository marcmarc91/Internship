package com.arobs.internship.week1.lab7.ex1;

class CofeeMaker {
    Cofee makeCofee(int count) throws CountCoffeeException {
        if (count >= 10) {
            throw new CountCoffeeException("Limit coffee at ", 10);
        }
        System.out.println("Make a coffe");
        int t = (int) (Math.random() * 100);
        int c = (int) (Math.random() * 100);
        Cofee cofee = new Cofee(t, c);
        return cofee;
    }

}