// Transaction class to log transactions
class Transaction {
    private String type;
    private double amount;
    private String details;
    private String date;

    public Transaction(String type, double amount, String details, String date) {
        this.type = type;
        this.amount = amount;
        this.details = details;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date: " + date + " | Type: " + type + " | Amount: $" + amount + " | Details: " + details;
    }
}
