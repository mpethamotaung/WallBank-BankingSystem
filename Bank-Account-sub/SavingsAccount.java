/*
Savings Account class
*/

//create account class
public class SavingsAccount {

    // initialize instance variables to store values
    private double balance;

    // account class constructor
    public SavingsAccount(double initialBalance) {

        if (initialBalance > 1000) {

            balance = initialBalance;
        }
    }

    // add funds to account(method add)
    public void deposit(double amount) {

        // new balance = balance + amount
        balance += amount;
    }

    // subtract funds from account(method subtract)
    public void withdraw(double amount) {

        // new balance = balance - amount
        balance += amount;
    }

    // balance inquiry (method get)
    public double getBalance() {

        // give the value of balance to calling method
        return balance;
    }

}