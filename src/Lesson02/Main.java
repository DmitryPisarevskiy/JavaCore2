package Lesson02;

import java.util.logging.SimpleFormatter;

public class Main {
    public static final int SIZE_ARR = 4;

    public static void main(String[] args) {
        String[][][] str = {
                {
                        {"16", "3", "2", "13"},
                        {"5", "10", "11", "8"},
                        {"9", "6", "7", "12"},
                        {"4", "15", "14", "1"}
                },
                {
                        {"16", "3", "2", "13"},
                        {"5", "10", "11", "8", "9"},
                        {"9", "6", "7", "12"},
                        {"4", "15", "14"}
                },
                {
                        {"1ф6", "3", "2", "13"},
                        {"5", "10", "1f1", "8"},
                        {"9", "6", "7", "1l2"},
                        {"4", "15", "14", "1"}
                },
                {
                        {"1ф6", "3", "2", "13"},
                        {"5", "10", "1f1", "8"},
                        {"9", "6", "7", "1l2","456"},
                        {"4", "15", "14", "1"}
                }
        };

        for (int i = 0; i < str.length; i++) {
            try {
                System.out.printf("Квадрат № %d: сумма всех элементов равна %d\n", (i + 1), sumOfStringArray(str[i]));
            } catch (MyArraySizeException e){
                System.out.printf("Квадрат № %d: Возникло исключение \"%s\"\n", (i + 1), e.getMessage());
                System.out.println("Количество строк в массиве: " + e.getNumOfRows());
                System.out.printf("Количество столбцов в массиве: в интервале от %d до %d\n", e.getMinNumOfColumns(), e.getMaxNumOfColumns());
            } catch(MyArrayDataException e) {
                System.out.printf("Квадрат № %d: Возникло исключение \"%s\"\n", (i + 1), e.getMessage());
                Cell[] cells=e.getCells();
                for (int j = 0; j < e.getNumOfMistakes(); j++) {
                    cells[j].info();
                }
            }  finally {
                System.out.println();
            }
        }

    }

    public static int sumOfStringArray(String[][] s) {
        int numOfRows = s.length;
        int minNumOfColumns = s[0].length;
        int maxNumOfColumns = s[0].length;
        int numOfMistakes=0;
        Cell[] cells=new Cell[SIZE_ARR*SIZE_ARR];
        // MyArraySizeException
        for (int i = 1; i < s.length; i++) {
            if (s[i].length < minNumOfColumns) {
                minNumOfColumns = s[i].length;
            }
            if (s[i].length > maxNumOfColumns) {
                maxNumOfColumns = s[i].length;
            }
        }
        if (numOfRows != SIZE_ARR || minNumOfColumns != SIZE_ARR || maxNumOfColumns != SIZE_ARR) {
            throw new MyArraySizeException("Несоответствие размера массива " + SIZE_ARR + "X" + SIZE_ARR, numOfRows, minNumOfColumns, maxNumOfColumns);
        }
        // MyArrayDataException
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j <s[i].length ; j++) {
                if (isInteger(s[i][j])) {
                    sum+=Integer.parseInt(s[i][j]);
                } else if (numOfMistakes<=cells.length-1){
                    cells[numOfMistakes]=new Cell(i,j,s[i][j]);
                    numOfMistakes++;
                }
            }
        }
        if (numOfMistakes!=0) {
            throw new MyArrayDataException("В массиве присутствуют нечисловые значения",cells,numOfMistakes);
        }
        return sum;
    }

    public static boolean isInteger(String value) {
        return value.matches("[-+]?\\d+");
    }
}
