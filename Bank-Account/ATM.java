/*

*/

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("Bank of BB");

        User aUser = theBank.addUser("John");
        // add checking accounts for users
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {

            // stay in the login prompt until successful login
            curUser = ATM.mainMenuPrompt(theBank, sc);

            // stay in the main menu until user quits
            ATM.printUserMenu(curUser, sc);
        }
    }

    // creating the mainMenuPrompt which takes class @Bank and @Scanner
    public static User mainMenuPrompt(Bank theBank, Scanner sc) {

        // initializing instance variables
        String userID;
        User authUser;

        // prompt the user or the user id or pin until the correct one is reached

        do {
            System.out.printf("\n\nWelcome to %s\n\n ", theBank.getName());
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();

            // try to get the user object corresponding to the ID and the pin

            authUser = theBank.userLogin(userID);

            if (authUser == null) {
                System.out.println("Incorrect user ID" + "Please try again");
            }

        } while (authUser == null); // continue looping until successful log in

        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc) {

        // print a summary of the users accounts
        theUser.printAccountsSummary();

        int option;
        // user menu user interface
        do {

            System.out.printf("Welcome %s What would you love to do?\n", theUser.name());
            System.out.println("1. Add account");
            System.out.println("2. Balance");
            System.out.println("3. Deposit ");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.println();
            System.out.println("Enter option: ");
            option = sc.nextInt();

            if (option < 1 || option > 5) {
                System.out.println("Invalid option. Please choose 1-5");
            }
        } while (option < 1 || option > 5);

        // process option
        switch (option) {

        case 1:
            ATM.showTransHistory(theUser, sc);
            break;
        case 2:
            ATM.withdrawlFunds(theUser, sc);
            break;
        case 3:
            ATM.depositFunds(theUser, sc);
            break;
        case 4:
            ATM.transferFunds(theUser, sc);

            break;
        }

        // redisplay menu unless user wants to quit
        if (option != 5) {
            // ATM.printUserMenu(theUser, sc);
            System.exit(1);
        }
    }

    public static void showTransHistory(User theUser, Scanner sc) {

        int theAcct;
        // get account whose transaction history to look at
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" + "whose transactions you want to see:",
                    theUser.numAccounts());
            theAcct = sc.nextInt() - 1;
            if (theAcct < 0 || theAcct >= theUser.numAccounts()) {
                System.out.println("Invalid Account: please try again");
            }

        } while (theAcct < 0 || theAcct >= theUser.numAccounts());
        /** print the transaction history **/
        theUser.printAcctTransHistory(theAcct);

    }

    public static void transferFunds(User theUser, Scanner sc) {
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;

        do {
            System.out.printf("Enter the number (1 - %d of the account\n" + "to Transfer from:", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;

            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid Account: please try again");
            }

        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBal = theUser.getAcctBalance(fromAcct);
        // get the account to Trasnfer to
        do {
            System.out.printf("Enter the number (1- %d) of the account\n" + "to transafer to:", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;

            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid Account: please try again");
            }

        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        do {
            System.out.printf("Enter the amount to Transfer(max $%.02f :$", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than Zero.");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than \n" + "balance of $%.02f\n", acctBal);
            }

        } while (amount < 0 || amount > acctBal);
        // finally do the transfer

        theUser.addAcctTransaction(fromAcct, -1 * amount,
                String.format("Transfer to account %s", theUser.getAcctUUID(toAcct)));
        theUser.addAcctTransaction(toAcct, amount,
                String.format("Transfer tp account %s", theUser.getAcctUUID(fromAcct)));
    }

    public static void withdrawlFunds(User theUser, Scanner sc) {

        // initial instance variables
        int fromAcct;
        double amount;
        double acctBal;
        String memo;

        do {
            System.out.printf("Enter the number (1-%d )of the account\n" + "to withdraw from:", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;

            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid Account: please try again");
            }

        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBal = theUser.getAcctBalance(fromAcct);

        do {
            System.out.printf("Enter the amount to Transfer(max $%.02f, args): $", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than Zero");
            } else if (amount > acctBal) {
                System.out.printf("Amount must not be greater than \n" + "balance of $%.02f\n", acctBal);
            }

        } while (amount < 0 || amount > acctBal);
        sc.nextLine();

        System.out.println("Enter a Memo: ");
        memo = sc.nextLine();

        theUser.addAcctTransaction(fromAcct, -1 * amount, memo);
    }

    // Deposit funds
    public static void depositFunds(User theUser, Scanner sc) {

        // initializing instance variables
        int toAcct;
        double amount;
        double acctBal;
        String memo;

        do {
            System.out.printf("Enter the number (1-%d )of the account\n" + "to deposit in:", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;

            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid Account: please try again");
            }

        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        acctBal = theUser.getAcctBalance(toAcct);

        do {
            System.out.printf("Enter the amount to Transfer(max $%.02f, args): $", acctBal);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than Zero");
            }

        } while (amount < 0);
        sc.nextLine();

        System.out.println("Enter a Memo: ");
        memo = sc.nextLine();

        theUser.addAcctTransaction(toAcct, amount, memo);
    }

}