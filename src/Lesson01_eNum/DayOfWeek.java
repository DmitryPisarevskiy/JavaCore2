package Lesson01_eNum;

public enum DayOfWeek {
    Sunday("Воскресенье",0), Monday("Понедельник",40), Tuesday("Вторник",32), Wednesday("Среда",24), Thursday("Четверг",16), Friday("Пятница",8), Saturday("Суббота",0);
    private int workHours;
    private String name;

    DayOfWeek(String name, int workHours) {
        this.workHours = workHours;
        this.name = name;
    }

    public void getWorkHours() {
        if (workHours == 0) {
            System.out.printf("Сегодня %s. Сегодня выходной\n", name);
        } else {
            System.out.printf("Сегодня %s. До конца рабочей недели осталось %d часов\n", name, workHours);
        }
    }
}
