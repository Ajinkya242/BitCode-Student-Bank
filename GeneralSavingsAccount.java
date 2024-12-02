// Subclass for General Savings Account
public class GeneralSavingsAccount extends SavingsAccount {
    public GeneralSavingsAccount(String accountNumber, String accountHolderName, double balance, String contactNumber, double interestRate) {
        super(accountNumber, accountHolderName, balance, contactNumber, interestRate);
    }

    @Override
    public String getAccountType() {
        return "General Savings Account";
    }
}
