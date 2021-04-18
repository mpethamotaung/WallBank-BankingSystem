/*

*/

//java packages import
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private String name;
    private String uuid;
    private ArrayList<Account> accounts;

    // User constructor
    public User(String name, Bank theBank) {

        // set user name
        this.name = name;

        // get Unique Universal ID for user
        this.uuid = theBank.getNewUserUUID();

        // create empty list of accounts
        this.accounts = new ArrayList<Account>();

        // print log message
        System.out.printf("New user %s, %s with ID %s created. \n", name, this.uuid);

    }

    // add account for users should be public
    public void addAccount(Account onAcct) {
        this.accounts.add(onAcct);
    }

    // get method for UUID
    public String getUUID() {
        return this.uuid;
    }

    // get method for name
    public String name() {
        return this.name;
    }

    // print account summary
    public void printAccountsSummary() {

        System.out.printf(" \n\n %s Accounts summary \n", this.name);

        for (int a = 0; a < this.accounts.size(); a++) {
            System.out.printf("%d. %s \n Accounts summary \n", a + 1, this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    // list number of accounts
    public int numAccounts() {
        return this.accounts.size();
    }

    // print transaction history
    public void printAcctTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }

    // get acc balance
    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    // get account UUID
    public String getAcctUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUUID();
    }

    // add acct transaction
    public void addAcctTransaction(int acctIdx, double amount, String memo) {
        this.accounts.get(acctIdx).addTransaction(amount, memo);
    }
}