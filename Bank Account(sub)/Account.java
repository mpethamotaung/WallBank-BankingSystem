/*
Account class
*/

//create account class
public class Account {

    // initialize instance variables to store values
    private double balance;

    // account class constructor
    public Account(double initialBalance) {

        if (initialBalance > 0.0) {

            balance = initialBalance;
        }
    }
}