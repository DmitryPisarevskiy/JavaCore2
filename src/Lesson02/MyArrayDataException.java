package Lesson02;

public class MyArrayDataException extends RuntimeException{
    private int row;
    private int column;
    private String enteredString;
    private Cell[] cells;
    private int numOfMistakes;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getEnteredString() {
        return enteredString;
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getNumOfMistakes() {
        return numOfMistakes;
    }

    public MyArrayDataException(String message, Cell[] cells, int numOfMistakes) {
        super(message);
        this.cells = cells;
        this.numOfMistakes = numOfMistakes;
    }
}
