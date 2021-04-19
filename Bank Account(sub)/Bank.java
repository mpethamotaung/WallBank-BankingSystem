/*
Bank Sys operates with Account objects
*/

public class Bank {

    // main method that begins the Java App
    public static void main(String[] args) {

        // Create Savings account object
        SavingsAccount account = new SavingsAccount(1000);

        //Display InitialBalance of Each Account
        System.out.printf("Savings Account Balance: $%.2f \n", account.getBalance());

        //Create Scanner to obtain input
        Scanner input = new Scanner(System.in);

        //initialize instance variable to store deposit amount
        double depositAmount;
        

}
