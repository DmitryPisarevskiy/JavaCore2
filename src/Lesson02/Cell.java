package Lesson02;

public class Cell {
    private int row;
    private int column;
    private String value;

    public Cell(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public void info(){
        System.out.printf("   Ячейка: строка %d, столбец %d, значение %s\n",row+1,column+1,value);
    }
}
