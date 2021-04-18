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

    // Summary get method
    public String getSummaryLine() {

        // get account balance
        double balance = this.getBalance();

        // format summary line
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
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

        // initialize balance
        double balance = 0;

        // for statement for transaction instance
        for (Transaction t : this.transaction) {
            balance += t.getAmount();
        }

        // return value
        return balance;
    }

    // print transaction history
    public void printTransHistory() {

        System.out.printf("\n Transcation History for accounts %s\n", this.uuid);
        for (int t = this.transaction.size() - 1; t >= 0; t--) {
            System.out.printf(this.transaction.get(t).getSummaryLine());

        }
        System.out.println();

    }

    // add transaction to history
    public void addTransaction(double amount, String memo) {

        // new transaction object with Transaction class(call)
        Transaction newTrans = new Transaction(amount, memo, this);
        this.transaction.add(newTrans);
    }

}