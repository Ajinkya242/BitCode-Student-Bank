import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Abstract class for accounts
public abstract class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String contactNumber;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double balance, String contactNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.contactNumber = contactNumber;
        this.transactionHistory = new ArrayList<>();
    }

    public abstract String getAccountType();

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount, "Deposited into account", LocalDate.now().toString()));
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction(TransactionType.WITHDRAWAL, amount, "Withdrew from account", LocalDate.now().toString()));
            System.out.println("Withdrew $" + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public void transferFunds(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction(TransactionType.TRANSFER, amount, "Transferred to " + recipient.getAccountHolderName(), LocalDate.now().toString()));
            System.out.println("Transferred $" + amount + " to " + recipient.getAccountHolderName() + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid transfer amount.");
        }
    }

    public void applyUPIPayment(double amount, String recipientName) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            transactionHistory.add(new Transaction(TransactionType.PAYMENT, amount, "Paid via UPI to " + recipientName, LocalDate.now().toString()));
            System.out.println("UPI payment of $" + amount + " to " + recipientName + " successful.");
        } else {
            System.out.println("Insufficient balance or invalid payment amount.");
        }
    }

    public void applyUPIReceipt(double amount, String senderName) {
        if (amount > 0) {
            this.balance += amount;
            transactionHistory.add(new Transaction(TransactionType.RECEIPT, amount, "Received UPI payment from " + senderName, LocalDate.now().toString()));
            System.out.println("UPI receipt of $" + amount + " from " + senderName + " successful.");
        } else {
            System.out.println("Invalid receipt amount.");
        }
    }

    public void viewAccountStatement() {
        System.out.println("\nAccount Statement:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: $" + balance);
        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void exportStatementToFile() {
        try (FileWriter writer = new FileWriter(accountNumber + "_statement.txt")) {
            writer.write("Account Statement:\n");
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Account Holder: " + accountHolderName + "\n");
            writer.write("Account Type: " + getAccountType() + "\n");
            writer.write("Balance: $" + balance + "\n");
            writer.write("\nTransaction History:\n");
            for (Transaction transaction : transactionHistory) {
                writer.write(transaction + "\n");
            }
            System.out.println("Statement exported to " + accountNumber + "_statement.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while exporting the statement.");
        }
    }
}
