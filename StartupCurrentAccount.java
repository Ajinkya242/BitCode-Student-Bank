// Subclass for Startup Current Account
public class StartupCurrentAccount extends CurrentAccount {
    public StartupCurrentAccount(String accountNumber, String accountHolderName, double balance, String contactNumber) {
        super(accountNumber, accountHolderName, balance, contactNumber);
    }

    @Override
    public String getAccountType() {
        return "Startup Current Account";
    }
}
