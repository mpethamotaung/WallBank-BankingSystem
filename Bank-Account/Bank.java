/*

*/

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    // Declaring instance variables
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    // bank constructor (name, ArrayList, User class & Account class)
    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    // generate new Id with UUID for user
    public String getNewUserUUID() {

        // initialize instance variables
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        // loop continues until ID is unique
        do {

            // generate ID
            uuid = "";

            for (int c = 0; c < len; c++) {

                uuid += ((Integer) rng.nextInt(10)).toString();
            }

            // validate uniqueness
            nonUnique = false;

            for (User u : this.users) {

                if (uuid.compareTo(u.getUUID()) == 0) {

                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);

        return uuid;
    }

    // generate unique IDs for each account
    public String getNewAccountUUID() {

        // declare & initialize instance variables
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        // loop until unique id is found
        do {
            // generate the number
            uuid = "";
            for (int c = 0; c < len; c++) {

                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            // check to make sure if unique
            nonUnique = false;
            for (Account a : this.accounts) {

                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }

    // add account
    public void addAccount(Account onAcct) {

        // set account
        this.accounts.add(onAcct);
    }

    // add user
    public User addUser(String name) {

        // create new user object through User class
        User newUser = new User(name);
        this.users.add(newUser);

        Account newAccount = new Account("Savings", newUser);

        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    // Get method for User name
    public String getName() {
        return this.name;
    }
}