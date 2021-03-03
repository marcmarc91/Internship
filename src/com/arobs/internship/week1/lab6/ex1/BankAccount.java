package com.arobs.internship.week1.lab6.ex1;


public class BankAccount implements Comparable<BankAccount> {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount < balance) {
            balance = balance - amount;
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BankAccount) {
            BankAccount obj = (BankAccount) o;
            return (owner.equals(obj.owner));
        } else return false;
    }

    @Override
    public int hashCode() {
        return ((31 * owner.hashCode()) * 31);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(BankAccount o) {
        if (balance < o.getBalance()) {
            return -1;
        } else if (balance == o.balance) {
            return 0;
        } else {
            return 1;
        }
    }
}
