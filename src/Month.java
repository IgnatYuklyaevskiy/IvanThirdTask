import java.util.ArrayList;

public class Month {
    ArrayList<Transaction> transactions;
    Transaction mostIncome;
    Transaction mostExpensive;

    Month(ArrayList<String> lines) {
        transactions = new ArrayList<Transaction>();
        int maxCommonIncomePrice = 0;
        int maxCommonExpensePrice = 0;
        for (int i = 1; i < lines.size(); i++) {
            String[] lineContents = lines.get(i).split(",");
            String name = lineContents[0];
            int quantity = Integer.parseInt(lineContents[2]);
            int unitPrice = Integer.parseInt(lineContents[3]);
            int commonCost = unitPrice * quantity;
            Boolean isExpense;
            if (lineContents[1].equals("TRUE")) {
                isExpense = true;
            } else {
                isExpense = false;
            }
            Transaction transaction = new Transaction(name, isExpense, quantity, unitPrice);
            transactions.add(transaction);
            if(isExpense && commonCost > maxCommonExpensePrice) {
                mostExpensive = transaction;
            }
            if(!isExpense && commonCost > maxCommonIncomePrice) {
                mostIncome = transaction;
            }
        }
    }

}