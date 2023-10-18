import java.sql.SQLOutput;
import java.util.ArrayList;

public class MonthlyReport {
    Month[] months;
    MonthlyReport() {
        months = new Month[3];
    }
    public void readMonthData() {
        String fileName = "m.20210x.csv";
        FileReader fileReader = new FileReader();
        for(int i = 1; i <= 3; i++) {
            fileName = fileName.substring(0, 7) + i + fileName.substring(8);
            ArrayList<String> lines = fileReader.readFileContents(fileName);
            months[i - 1] = new Month(lines);
        }
    }
    public void printMonthData() {
        for(int i = 0; i < 3; i++) {
            Transaction mostExpensive = months[i].mostExpensive;
            Transaction mostIncome = months[i].mostIncome;
            System.out.println(MonthsNames.values()[i].getName());

            System.out.println("Самый прибыльный товар: " + mostIncome.name + " " + mostIncome.unitPrice * mostIncome.quantity);
            System.out.println("Самая большая трата: " + mostExpensive.name + " " + mostExpensive.unitPrice * mostExpensive.quantity);
            System.out.println();
        }
    }
}





