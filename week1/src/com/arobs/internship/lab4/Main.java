package com.arobs.internship.week1.lab4;


import com.arobs.internship.week1.lab4.ex2.Author;
import com.arobs.internship.week1.lab4.ex1.Circle;
import com.arobs.internship.week1.lab4.ex1.TestCircle;
import com.arobs.internship.week1.lab4.ex2.TestAuthor;
import com.arobs.internship.week1.lab4.ex3.Book;
import com.arobs.internship.week1.lab4.ex3.TestBook;
import com.arobs.internship.week1.lab4.ex4.BookPro;
import com.arobs.internship.week1.lab4.ex4.TestBookPro;
import com.arobs.internship.week1.lab4.ex5.Cylinder;
import com.arobs.internship.week1.lab4.ex5.TestCylinder;
import com.arobs.internship.week1.lab4.ex6.TestShape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberEx = 0;
        do {

            System.out.println("Enter the exercise number (1-6) or 0 to close: ");
            while (!scanner.hasNextInt()) {
                System.out.printf("%s is not valid number. %n", scanner.next());
            }
            numberEx = scanner.nextInt();

            switch (numberEx) {
                case 1:
                    TestCircle testCircle = new TestCircle(new Circle(23));
                    testCircle.displayInfo();
                    break;
                case 2:
                    TestAuthor testAuthor = new TestAuthor(new Author("John Peter", "john.peter@example.com", 'm'));
                    testAuthor.displayInfo();
                    break;
                case 3:
                    TestBook testBook = new TestBook(
                            new Book("Java Book",
                                    new Author("John Peter", "john.peter@example.com", 'm'),
                                    12.06,
                                    25));
                    testBook.displayBook();
                    break;
                case 4:
                    TestBookPro testBookPro = new TestBookPro(
                            new BookPro("Java Book",
                                    new Author[]{
                                            new Author("John Peter", "john.peter@example.com", 'm'),
                                            new Author("Bryson Morty", "bmorty@example.com", 'm'),
                                            new Author("Anise Samantha", "anises@example.com", 'f')
                                    },
                                    12.06,
                                    25)
                    );
                    testBookPro.displayInfoBook();
                    break;
                case 5:
                    TestCylinder testCylinder = new TestCylinder(new Cylinder(6.4, 14.2));
                    testCylinder.diplayCylinder();
                    break;
                case 6:
                    TestShape testShape = new TestShape();
                    testShape.displayShape();
            }

        } while (numberEx != 0);
    }
}
