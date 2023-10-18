import java.util.ArrayList;

public class CheckReports {
    MonthlyReport monthlyReport;
    YearlyReport yearlyReport;

    public CheckReports(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }

    public int checkReports() {

        for(int i = 0; i < 3; i++) {
            int monthSumExpenses = 0;
            int monthSumIncome = 0;
            ArrayList<Transaction> transactions = monthlyReport.months[i].transactions;
            for(int j = 0; j < transactions.size(); j++) {
                if(transactions.get(j).isExpense) {
                    monthSumExpenses += transactions.get(j).quantity * transactions.get(j).unitPrice;
                } else {
                    monthSumIncome += transactions.get(j).quantity * transactions.get(j).unitPrice;
                }
            }
            if(monthSumExpenses != yearlyReport.information.get(i).expensesAmount
            || monthSumIncome != yearlyReport.information.get(i).incomeAmount) {
                return i + 1;
            }
        }
        return -1;
    }
}
