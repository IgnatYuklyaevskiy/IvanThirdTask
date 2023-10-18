public class Transaction {
    String name;
    boolean isExpense;
    int quantity;
    int unitPrice;

    public Transaction(String name, boolean isExpense, int quantity, int unitPrice) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
