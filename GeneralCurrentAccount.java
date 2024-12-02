// Subclass for General Current Account
public class GeneralCurrentAccount extends CurrentAccount {
    public GeneralCurrentAccount(String accountNumber, String accountHolderName, double balance, String contactNumber) {
        super(accountNumber, accountHolderName, balance, contactNumber);
    }

    @Override
    public String getAccountType() {
        return "General Current Account";
    }
}
