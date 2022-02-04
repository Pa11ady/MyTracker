import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static StepTracker stepTracker = new StepTracker();

    public static void main(String[] args) {
        stepTracker.initTestData(); //!!!!!! тест

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
                    EditGoalCountStepsForDay();
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
        System.out.println("0 - Выйти из приложения");
        System.out.println("================================================");
    }

    private static void inputCountStepsForDay() {
        int month;
        int day;
        int steps;
        do {
            System.out.println("Введите номер месяца с 1 - 12");
            month = scanner.nextInt();
        } while (month < 1|| month > 12);
        do {
            System.out.println("Введите день с 1 - 30");
            day = scanner.nextInt();
        } while (day < 1 || day > 30);
        do {
            System.out.println("Введите неотрицательное число шагов");
            steps = scanner.nextInt();
        } while (steps < 0);
        stepTracker.setSteps(month, day, steps);
    }

    private static void PrintStatisticsForMonth() {
        int month;
        do {
            System.out.println("Введите номер месяца с 1 - 12");
            month = scanner.nextInt();
        } while (1 > month || month > 12);

        Integer[] monthDate = stepTracker.getMonthDate(month);
        if (monthDate == null) {
            System.out.println("Нет статистики по такому месяцу");
            return;
        }
        int cntDays = monthDate.length;
        for (int i = 0; i < cntDays - 1; i++) {
            System.out.printf("%d день: %d, ", i + 1,  monthDate[i]);
        }
        System.out.printf("%d день: %d\n",  cntDays,   monthDate[cntDays-1]);
        System.out.println("===");
        stepTracker.printDateTest(month);
    }

    private static void EditGoalCountStepsForDay() {
        int goalSteps;
        System.out.println("3 - Изменить цель по количеству шагов в день");
        do {
            System.out.println("Введите неотрицательное число шагов");
            goalSteps = scanner.nextInt();
        } while (goalSteps < 0);
        stepTracker.setGoalSteps(goalSteps);
    }
}

