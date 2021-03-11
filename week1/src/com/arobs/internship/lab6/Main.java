package com.arobs.internship.week1.lab6;


import com.arobs.internship.week1.lab6.ex1.BankAccount;
import com.arobs.internship.week1.lab6.ex2.Bank;
import com.arobs.internship.week1.lab6.ex3.BankSet;
import com.arobs.internship.week1.lab6.ex4.Definition;
import com.arobs.internship.week1.lab6.ex4.Dictionary;
import com.arobs.internship.week1.lab6.ex4.Word;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberEx = 0;

        do {
            System.out.println("Enter the exercise number (1-4) or 0 to close: ");
            while (!scanner.hasNextInt()) {
                System.out.printf("%s is not valid number. %n", scanner.next());
            }
            numberEx = scanner.nextInt();
            switch (numberEx) {
                case 1:

                    BankAccount bk1 = new BankAccount("John Peter", 772.3);
                    BankAccount bk2 = new BankAccount("John Peter", 772.3);
                    bk1.withdraw(649);

                    Set<BankAccount> bankAccounts = new HashSet<>();
                    bankAccounts.add(bk1);
                    bankAccounts.add(bk2);

                    System.out.println(bankAccounts);
                    break;
                case 2:
                    Bank bank = new Bank(
                            new ArrayList<>() {{
                                add(new BankAccount("OwnerOne", 603));
                                add(new BankAccount("OwnerTwo", 214));
                            }});
                    bank.addAccount("OwnerThree", 98);
                    bank.addAccount("OwnerFour", 998);
                    bank.addAccount("OwnerFive", 1021);

                    System.out.println("Account: " + bank.getAccount("OwnerTwo"));
                    bank.printAccounts();
                    bank.printAccounts(600, 2000);

                    bank.getBankAccounts().sort(Comparator.comparing(BankAccount::getOwner));
                    System.out.println(bank.getBankAccounts());
                    break;
                case 3:
                    BankSet bankSet = new BankSet();
                    bankSet.addAccount("Dale", 654);
                    bankSet.addAccount("Teresa", 452);
                    bankSet.addAccount("Beatrice", 786);
                    bankSet.addAccount("Emilia", 1235);
                    bankSet.addAccount("Cora", 28);

                    System.out.println("Account: " + bankSet.getAccount("Beatrice"));
                    bankSet.printAccounts();
                    bankSet.printAccounts(750, 1500);
                    break;
                case 4:
                    Dictionary dictionary = new Dictionary();
                    dictionary.addWord(new Word("wordOne"), new Definition("defOne"));
                    dictionary.addWord(new Word("wordTwo"), new Definition("defTwo"));
                    dictionary.addWord(new Word("wordThree"), new Definition("defThree"));

                    Word word = new Word("WordTest");
                    Definition definition = new Definition("DefTest");
                    dictionary.addWord(word, definition);

                    dictionary.getAllDefinitions();
                    dictionary.getAllWord();
                    System.out.printf("Word: %s%n", dictionary.getDefinition(word).getDescription());
                    break;
            }

        } while (numberEx != 0);
    }
}
