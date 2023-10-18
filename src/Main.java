import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        boolean wasMonthDataRead = false;
        boolean wasYearDataRead = false;

        CheckReports checkReports = new CheckReports(monthlyReport, yearlyReport);
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            if (command.equals("1")) {
                monthlyReport.readMonthData();
                wasMonthDataRead = true;
                System.out.println("Файл успешно считан!");
            } else if (command.equals("2")) {
                yearlyReport.readYearData();
                wasYearDataRead = true;
                System.out.println("Файл успешно считан!");
            } else if (command.equals("3")) {
                if(!(wasMonthDataRead && wasYearDataRead)) {
                    System.out.println("Сначала считайте все данные!");
                } else {
                    if(checkReports.checkReports() == -1) {
                        System.out.println("Всё верно!");
                    } else {
                        System.out.printf("Не совпадают данные в месяце номер %d !", checkReports.checkReports());
                    }
                }

            } else if (command.equals("4")) {
                if(!wasMonthDataRead) {
                    System.out.println("Сначала считайте все данные за месяцы!");
                } else {
                    monthlyReport.printMonthData();
                }
            } else if (command.equals("5")) {
                if(!wasYearDataRead) {
                    System.out.println("Сначала считайте все данные за год!");
                } else {
                    yearlyReport.printYearData();
                }
            } else if (command.equals("%@Q")) {
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            System.out.println();
        }
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println();
        System.out.println("1.Считать все месячные расходы");
        System.out.println("2.Считать годовой отчет");
        System.out.println("3.Сверить отчеты");
        System.out.println("4.Вывести информацию обо всех месячных отчетах");
        System.out.println("5.Вывести информацию о годовом отчете");
        System.out.println("%@Q.Выход из программы");
        System.out.println();
    }


}

