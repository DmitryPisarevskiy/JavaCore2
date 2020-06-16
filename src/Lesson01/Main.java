package Lesson01;

public class Main {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_GREEN="\u001B[32m";

    public static void main(String[] args) {
        Competitable[] competitors={
                new Human("Дункан Макклауд",1000,10),
                new Cat("Барсик"),
                new Robot("Валли"),
                new Robot("Терминатор", 500,7)
        };

        Obstacles[] obstacles={
                new Wall(2),
                new TreadMill(10),
                new Wall(7),
                new TreadMill(600)
        };

        System.out.println("Соревнования начинаются!\n");
        System.out.println(ANSI_GREEN+"Участники:"+ANSI_RESET);
        for (Competitable competitor : competitors) {
            competitor.info();
        }
        System.out.println();

        for (int i = 0; i <obstacles.length ; i++) {
            System.out.print(ANSI_GREEN+"Испытание № "+(i+1)+". "+ANSI_RESET);
            obstacles[i].info();
            for (Competitable competitor : competitors) {
                if (competitor.isOnDistance()) {
                    obstacles[i].justDoIt(competitor);
                }
            }
            System.out.println();
        }

        System.out.println(ANSI_GREEN+"В конце остались:"+ANSI_RESET);
        for (Competitable competitor : competitors) {
            if (competitor.isOnDistance()) {
                competitor.info();
            }
        }

    }
}
