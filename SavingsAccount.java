import java.time.LocalDate;

public abstract class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, String contactNumber, double interestRate) {
        super(accountNumber, accountHolderName, balance, contactNumber);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return (getBalance() * interestRate) / 100;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
        getTransactionHistory().add(new Transaction(TransactionType.INTEREST, interest, "Interest applied", LocalDate.now().toString()));
        System.out.println("Applied interest of $" + interest + " to the account.");
    }
}
