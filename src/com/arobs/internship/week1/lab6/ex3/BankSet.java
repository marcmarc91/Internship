package com.arobs.internship.week1.lab6.ex3;

import com.arobs.internship.week1.lab6.ex1.BankAccount;

import java.util.TreeSet;

public class BankSet {
    private TreeSet<BankAccount> bankAccounts;

    public BankSet() {
        this.bankAccounts = new TreeSet<>();
    }

    public void addAccount(String owner, double balance) {
        bankAccounts.add(new BankAccount(owner, balance));
    }

    public void printAccounts() {
        System.out.println(bankAccounts.descendingSet());
    }

    public void printAccounts(double minBalance, double maxBalance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BankAccount bk : bankAccounts) {
            if (bk.getBalance() >= minBalance && bk.getBalance() <= maxBalance) {
                stringBuilder.append(bk.getOwner());
                stringBuilder.append(": ");
                stringBuilder.append(bk.getBalance());
                stringBuilder.append(", ");
            }
        }
        System.out.printf("Balance range %s - %s: %s%n", minBalance, maxBalance, stringBuilder);
    }

    public BankAccount getAccount(String owner) {
        for (BankAccount bk : bankAccounts) {
            if (bk.getOwner().equals(owner)) {
                return bk;
            }
        }
        return null;
    }

    public TreeSet<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
