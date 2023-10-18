import java.lang.reflect.Array;
import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearInformation> information;
    YearlyReport() {
        information = new ArrayList<YearInformation>();
    }
    public void readYearData() {
        String fileName = "y.2021.csv";
        FileReader fileReader = new FileReader();
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        for(int i = 1; i < lines.size(); i+=2) {
            String[] firstLineContents = lines.get(i).split(",");
            String[] secondLineContents = lines.get(i + 1).split(",");
            int month = Integer.parseInt(firstLineContents[0]);
            int incomeAmount;
            int expensesAmount;
            if(firstLineContents[2].equals("true")) {
                expensesAmount = Integer.parseInt(firstLineContents[1]);
                incomeAmount = Integer.parseInt(secondLineContents[1]);
            } else {
                expensesAmount = Integer.parseInt(secondLineContents[1]);
                incomeAmount = Integer.parseInt(firstLineContents[1]);
            }
            information.add(new YearInformation(month, incomeAmount, expensesAmount));
        }

    }
    public void printYearData() {
        System.out.println("2021 год");
        int sumIncome = 0;
        int sumExpenses = 0;
        for(int i = 0; i < 3; i++) {
            System.out.println("Прибыль за " + MonthsNames.values()[i].getName() + " : " + information.get(i).incomeAmount);
            sumIncome += information.get(i).incomeAmount;
            sumExpenses += information.get(i).expensesAmount;
        }
        int averageIncome = sumIncome / 3;
        int averageExpenses = sumExpenses / 3;
        System.out.println("Средний расход за имеющиеся операции в году: " + averageExpenses);
        System.out.println("Средний доход за имеющиеся операции в году: " + averageIncome);
    }
}
