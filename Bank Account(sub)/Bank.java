import java.util.Scanner;

/*
Bank Sys operates with Account objects
*/

public class Bank {

    // main method that begins the Java App
    public static void main(String[] args) {

        // Create Savings account object
        SavingsAccount account1 = new SavingsAccount(1000);

        //Display InitialBalance of Each Account
        System.out.printf("Savings Account Balance: $%.2f \n", account1.getBalance());

        //Create Scanner to obtain input
        Scanner input = new Scanner(System.in);

        //initialize instance variable to store deposit amount
        double depositAmount;

        /* ------------- Deposit ---------------- */
        //prompt user to enter deposit amount
        System.out.print("Enter deposit amount");
        
        //set deposit amount = user input(int)
        depositAmount = input.nextDouble();

        System.out.printf(" \n adding %.2f to Savings Account\n\n", depositAmount);
        account1.deposit(depositAmount);

        /* --------------- Withdraw -------------- */

}
