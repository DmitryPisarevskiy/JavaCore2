package Lesson01_eNum;

public class MaineNum {
    public static void main(String[] args) {
        DayOfWeek day1=DayOfWeek.Friday;
        DayOfWeek day2=DayOfWeek.valueOf("Monday");
        DayOfWeek day3=DayOfWeek.Saturday;
        day1.getWorkHours();
        day2.getWorkHours();
        day3.getWorkHours();
    }
}
