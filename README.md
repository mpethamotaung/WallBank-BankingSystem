/**
Banking System README
   
This Java program simulates a basic banking system with functionalities such as account management, transactions, and balance inquiries.

Features:
 * Account Creation: Users can open new accounts with the bank.
 * Deposit and Withdrawal: Users can deposit money into and withdraw money from their accounts.
 * Transfer: Users can transfer funds between accounts.
 * Balance Inquiry: Users can check their account balances.
   
Technologies Used:
 * Java: The core programming language used for developing the banking system.
 * Object-Oriented Programming (OOP): Java's OOP principles are employed for designing classes such as Account and Transaction.
   
Getting Started:
  1. Clone the repository: git clone https://github.com/your_username/banking-system.git
  2. Compile the Java files: javac *.java
  3. Run the main class: java Main
  4. Follow the prompts to interact with the banking system.
  
Usage:
 * Follow the instructions displayed in the console to perform various banking operations.
 * Create new accounts, deposit and withdraw funds, transfer money between accounts, and check balances.
   
 * Contributors:
    [Mpetha Sthembiso Motaung] <mpethamotaung@gmail.com>
   
License:
 NULL

public class Main {
    public static void main(String[] args) {
        // Main method to execute the banking system
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.start();
    }
}
