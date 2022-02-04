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

    public void printDateTest(int month) { //тестовая печать
        Integer[] arr = monthDataMap.get(month);
        if (arr != null) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public void initTestData() {
        int[] month1 = {10, 20, 30, 10, 0, 0, 100, 100, 100};
        int[] month2 = {0};
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
    public StepTracker() {
    }

}
