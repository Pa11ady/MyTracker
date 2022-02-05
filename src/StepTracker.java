import java.util.Arrays;
import java.util.HashMap;

public class StepTracker {
    private int goalSteps = 10000;
    private final int COUNT_DAYS = 30;
    private final HashMap<Integer, Integer[]> monthDataMap = new HashMap<>();

    public void setGoalSteps(int goalSteps) {
        this.goalSteps = goalSteps;
    }

    public void setSteps(int month, int day, int steps) {
        Integer[] monthData = monthDataMap.get(month);
        if (monthData == null) {
            monthData = new Integer[COUNT_DAYS];
            for (int i = 0; i < COUNT_DAYS; i++) {
                monthData[i] = 0;
            }
            monthDataMap.put(month, monthData);
        }
        monthData[day-1] = steps;
    }

    public Integer[] getMonthDate(int month) {
        Integer[] monthData = monthDataMap.get(month);
        if (monthData == null) return null;
        return monthData.clone();
    }

    public MonthStat getMonthStatistics(int month) {
        MonthStat monthStat = new MonthStat();
        Integer[] monthData = monthDataMap.get(month);
        if (monthData == null) return null;
        int maxSteps = 0;
        int sumSteps = 0;
        for (int i = 0; i < COUNT_DAYS; i++) {
            if (maxSteps < monthData[i]) {
                maxSteps = monthData[i];
            }
            if (monthData[i] > 0) {

                sumSteps += monthData[i];
            }
        }
        // будет отбрасывание дробной части думаю все переживут потерю 1 шага :)
        monthStat.avgSteps = sumSteps / COUNT_DAYS;
        monthStat.maxSteps = maxSteps;
        monthStat.totalSteps = sumSteps;
        return  monthStat;
    }

    public  int getBestSeries(int month) {
        Integer[] monthData = monthDataMap.get(month);
        if (monthData == null) return 0;
        int maxSeries = 0;
        int curSeries = 0;
        for (int steps : monthData) {
            if (steps >= goalSteps) {
                curSeries++;
            } else {
                curSeries = 0;
            }
            if (maxSeries < curSeries) {
                maxSeries = curSeries;
            }
        }
        return maxSeries;
    }

    public void printDateTest(int month) { //тестовая печать
        Integer[] arr = monthDataMap.get(month);
        if (arr != null) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public void initTestData() {
        int[] month1 = {100000, 20, 30, 10, 10, 0, 0, 0, 100, 100, 200, 0, 500, 500};
        int[] month2 = {1000};
        int[] month10 = {0, 0, 0, 0, 400, 500, 600, 700, 800, 0, 0};
        initTestDataFromArr(1, month1);
        initTestDataFromArr(2, month2);
        initTestDataFromArr(10, month10);
    }

    private void initTestDataFromArr(int month, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            setSteps(month, i +1, arr[i]);
        }
    }
}

class MonthStat {
    int totalSteps;
    int maxSteps;
    int avgSteps;
}
