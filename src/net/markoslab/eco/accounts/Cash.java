package net.markoslab.eco.accounts;

/**
 * Created by marko on 1/11/15.
 */
public class Cash {
    private double balance;


    public double getBalance() {
        return balance;
    }

    public Cash setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public boolean deposit(double amount) {
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
