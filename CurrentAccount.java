// Abstract class for Current Accounts
public abstract class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, String accountHolderName, double balance, String contactNumber) {
        super(accountNumber, accountHolderName, balance, contactNumber);
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }
}
