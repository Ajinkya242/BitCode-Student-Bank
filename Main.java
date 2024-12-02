public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adding accounts
        Account studentAccount = new StudentSavingsAccount("S123", "AAA", 1000.0, "1234567890", 2.5);
        Account generalAccount = new GeneralSavingsAccount("G123", "BBB", 2000.0, "0987654321", 3.0);
        Account generalCurrentAccount = new GeneralCurrentAccount("C123", "CCC", 500.0, "1234567890");
        Account startupCurrentAccount = new StartupCurrentAccount("C124", "DDD", 1500.0, "9876543210");

        bank.addAccount(studentAccount);
        bank.addAccount(generalAccount);
        bank.addAccount(generalCurrentAccount);
        bank.addAccount(startupCurrentAccount);

        // Viewing details
        bank.viewAccountDetails();

        // Searching for an account
        bank.searchAccount("S123");

        // Applying interest to savings accounts
        bank.depositInterestToSavingsAccounts();

        // Performing UPI transactions
        System.out.println("\nPerforming UPI Transactions:");
        studentAccount.applyUPIPayment(200.0, "Alice");
        generalAccount.applyUPIReceipt(300.0, "Bob");

        // Backup account details
        bank.backupAccounts();
    }
}
