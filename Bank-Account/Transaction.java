/*

*/

public class Transaction {

    // initializing instance variables
    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    //
    public Transaction(double amount, Account inAccount) {

        // set transaction args
        this.amount = amount;
        this.inAccount = inAccount;

        // set timestamp and memo
        this.timestamp = new Date();
        this.memo = "";
    }

    //
    public Transaction(double amount, String memo, Account inAccount) {

        // call the two args
        this(amount, inAccount);

        // set the memo
        this.memo = memo;
    }

    // get method that returns amount
    public double getAmount() {
        return this.amount;
    }

    // get method returns summary
    public String getSummaryLine(){
        if (this.amount >= 0){
            return String.format("%s : $%.02f :%s,",this.timestamp.toString(),this.amount,this.memo);
        }else{
        return String.format("%s : $(%.02f) :%s,",this.timestamp.toString(),this.amount,this.memo);
        
    }

}
