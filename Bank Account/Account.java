/* Account class with a constructor to validate and
    initialize instance variable balance of type double. */

import java.util.ArrayList;

public class Account {

    // initializing instance variables
    private double balance;
    private String name;
    private User holder;
    private String uuid;
    private ArrayList<Transaction> transaction;

    // constructor account class
    public Account(String name, User holder, Bank theBank) {

        // set account name and holder
        this.name = name;
        this.holder = holder;

        // get account ID
        this.uuid = theBank.getNewAccountUUID();

        // initialize transaction
        this.transaction = new ArrayList<Transaction>();

    }// end account constructor

    // get account id
    public String getUUID() {

        return this.uuid;
    }

    // add amount to the account
    public void deposit(double amount) {

        balance += amount;
    }

    // subtract amount from account
    public void withdraw(double amount) {
        balance -= amount;
    }

    // return account balance
    public double getBalance() {
        return balance;
    }

    // print transaction history

}