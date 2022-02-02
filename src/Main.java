import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    inputCountStepsForDay();
                    break;
                case 2:
                    PrintStatisticsForMonth();
                    break;
                case 3:
                    EditCountStepsForDay();
                    break;
                case 4:
                    PrintMonthlyReports();
                    break;
                case 0:
                    System.out.println("0 - Выйти из приложения");
                    scanner.close();
                    return;
                default:
                    System.out.println("Извините, такой команды нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("================================================");
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Напечатать статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("0 - Выйти из приложения");
        System.out.println("================================================");
    }

    private static void inputCountStepsForDay() {
        System.out.println("1 - Ввести количество шагов за день");
    }

    private static void PrintStatisticsForMonth() {
        System.out.println("2 - Напечатать статистику за месяц");
    }

    private static void EditCountStepsForDay() {
        System.out.println("3 - Изменить цель по количеству шагов в день");
    }

    private static void PrintMonthlyReports() {
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
    }
}

