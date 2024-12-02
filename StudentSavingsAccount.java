// Subclass for Student Savings Account
public class StudentSavingsAccount extends SavingsAccount {
    public StudentSavingsAccount(String accountNumber, String accountHolderName, double balance, String contactNumber, double interestRate) {
        super(accountNumber, accountHolderName, balance, contactNumber, interestRate);
    }

    @Override
    public String getAccountType() {
        return "Student Savings Account";
    }
}
