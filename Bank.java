import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Bank class to manage accounts and provide operations
public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            System.out.println("Account with this number already exists.");
        } else {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Account added successfully.");
        }
    }

    public void removeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateAccountInfo(String accountNumber, String newHolderName, double newBalance, String newContactNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            // Assuming updating to a generic type for demonstration; modify as needed for real use
            Account updatedAccount = new GeneralSavingsAccount(accountNumber, newHolderName, newBalance, newContactNumber, 0);
            accounts.put(accountNumber, updatedAccount);
            System.out.println("Account information updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void viewAccountDetails() {
        List<Account> sortedAccounts = new ArrayList<>(accounts.values());
        sortedAccounts.sort(Comparator.comparing(Account::getAccountNumber));
        System.out.println("Accounts sorted by account number:");
        for (Account account : sortedAccounts) {
            System.out.println(account.getAccountNumber() + " - " + account.getAccountHolderName());
        }

        sortedAccounts.sort(Comparator.comparing(Account::getAccountHolderName));
        System.out.println("\nAccounts sorted by account name:");
        for (Account account : sortedAccounts) {
            System.out.println(account.getAccountHolderName() + " - " + account.getAccountNumber());
        }

        sortedAccounts.sort(Comparator.comparingDouble(Account::getBalance).reversed());
        System.out.println("\nAccounts sorted by balance:");
        for (Account account : sortedAccounts) {
            System.out.println(account.getAccountNumber() + " - $" + account.getBalance());
        }
    }

    public void searchAccount(String searchTerm) {
        for (Account account : accounts.values()) {
            if (account.getAccountNumber().equals(searchTerm) || account.getContactNumber().equals(searchTerm)
                    || account.getAccountHolderName().equalsIgnoreCase(searchTerm)) {
                System.out.println("Account found: " + account.getAccountHolderName() + " (" + account.getAccountNumber() + ")");
            }
        }
    }

    public void depositInterestToSavingsAccounts() {
        for (Account account : accounts.values()) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).applyInterest();
            }
        }
    }

    public void backupAccounts() {
        try (FileWriter writer = new FileWriter("bank_backup.txt")) {
            for (Account account : accounts.values()) {
                writer.write("Account Number: " + account.getAccountNumber() + "\n");
                writer.write("Account Holder: " + account.getAccountHolderName() + "\n");
                writer.write("Account Type: " + account.getAccountType() + "\n");
                writer.write("Balance: $" + account.getBalance() + "\n");
                writer.write("\n");
            }
            System.out.println("Backup completed.");
        } catch (IOException e) {
            System.out.println("An error occurred during backup.");
        }
    }
}
